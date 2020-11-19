package ru.nsu.g.beryanov.compiler.processing;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import ru.nsu.g.beryanov.compiler.exception.CompilationError;
import ru.nsu.g.beryanov.compiler.operation.bool.BooleanOperation;
import ru.nsu.g.beryanov.compiler.function.Function;
import ru.nsu.g.beryanov.compiler.operation.numerical.NumericalOperation;
import ru.nsu.g.beryanov.compiler.type.IntType;
import ru.nsu.g.beryanov.compiler.type.PrimitiveType;
import ru.nsu.g.beryanov.compiler.type.StringType;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import ru.nsu.g.beryanov.compiler.utility.PatternTemplate;
import ru.nsu.g.beryanov.compiler.utility.RegularExpressionTemplate;

import java.io.BufferedReader;
import java.io.FileOutputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
@Setter
@Getter
public class Compiler {
    private Map<String, PrimitiveType> variablesPool;
    private Map<String, Label> labelsPool;

    private ClassWriter classWriter;
    private MethodVisitor methodVisitor;

    private int variablesCounter = 1;

    private BufferedReader inputFile;

    @Autowired
    private PatternTemplate patternTemplate;

    @Autowired
    private RegularExpressionTemplate regularExpressionTemplate;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private List<NumericalOperation> numericalOperations;

    @Autowired
    private List<BooleanOperation> booleanOperations;

    @Autowired
    private List<Function> functions;

    public Compiler() {
        variablesPool = new HashMap<>();
        labelsPool = new HashMap<>();

        classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS + ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "CompiledApplication", null, "java/lang/Object", null);

        methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);

        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(1, 1);
        methodVisitor.visitEnd();

        methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        methodVisitor.visitCode();
    }

    public PrimitiveType parseSimpleValue(String src) {
        if (Pattern.matches(patternTemplate.getIntTemplate(), src)) {
            IntType variable = (IntType) applicationContext.getBean("intType");
            variable.addValueToPool(src);
            return variable;
        }

        if (variablesPool.containsKey(src)) {
            PrimitiveType variable = variablesPool.get(src);
            PrimitiveType newVariable = variable.copyVariable();
            newVariable.getValueFromPool(src, newVariable.getTypeName());
            return newVariable;
        }

        throw new CompilationError("Incorrect value: " + src);
    }

    public PrimitiveType evaluateValue(String src) {
        if (Pattern.matches(patternTemplate.getStringTemplate(), src)) {
            StringType variable = (StringType) applicationContext.getBean("stringType");
            src = src.trim();
            variable.addValueToPool(src.substring(1, src.length() - 1));
            return variable;
        }

        return generateNumberExpression(src);
    }

    public PrimitiveType generateNumberExpression(String src) {
        src = src.replace(" ", "");

        if (src.equals("")) {
            throw new CompilationError("Empty value");
        }

        int previousIndex = 0;
        int nearestIndex;
        int currentIndex;

        NumericalOperation lastOperation = null;
        NumericalOperation currentOperation = null;

        PrimitiveType primitiveType = null;

        while (previousIndex < src.length()) {
            nearestIndex = -1;

            for (NumericalOperation numericalOperation : numericalOperations) {
                currentIndex = src.indexOf(numericalOperation.getTag(), previousIndex);
                if ((currentIndex < nearestIndex || nearestIndex == -1) && currentIndex != -1) {
                    nearestIndex = currentIndex;
                    currentOperation = numericalOperation;
                }
            }

            if (nearestIndex == -1) {
                primitiveType = parseSimpleValue(src.substring(previousIndex));
                if (lastOperation != null)
                    lastOperation.process();
            } else {
                primitiveType = parseSimpleValue(src.substring(previousIndex, nearestIndex));
                if (lastOperation != null)
                    lastOperation.process();
                lastOperation = currentOperation;
            }

            previousIndex = nearestIndex == -1 ? src.length() : nearestIndex + 1;
        }

        return primitiveType;
    }

    private void evaluateIntValue(String src) {
        String[] keyValue = src.split("=");

        if (keyValue.length != 2) {
            throw new CompilationError("Incorrect assignments amount");
        }

        PrimitiveType s = evaluateValue(keyValue[1]);
        s.saveVariable(keyValue[0].replace("->", "").replace("new", "").replace(" ", ""));
    }

    public void assignVariable(String src) {
        String[] keyValue = src.split("=");

        if (keyValue.length != 2) {
            throw new CompilationError("Incorrect assignments amount");
        }

        keyValue[0] = keyValue[0].replace(" ", "");

        PrimitiveType s = evaluateValue(keyValue[1]);

        if (!variablesPool.containsKey(keyValue[0])) {
            throw new CompilationError("Incorrect variable: " + keyValue[0]);
        }

        s.putExistingVariableToPool(keyValue[0]);
    }

    private void proceedScopedExpression(String src, Label label) {
        int index;

        for (BooleanOperation operation : booleanOperations) {
            index = src.indexOf(operation.getTag());
            if (index != -1) {
                if (src.indexOf(operation.getTag(), index + 1) != -1) {
                    throw new CompilationError("Incorrect if: " + src);
                }

                evaluateValue(src.substring(0, index));

                if (operation.getTag().length() == 2) {
                    evaluateValue(src.substring(index + 2));
                } else {
                    evaluateValue(src.substring(index + 1));
                }

                operation.jump(label);
                processCompilation();

                return;
            }
        }
    }

    public void proceedIfCondition(String src) {
        Label ifLabel = new Label();

        src = src.replace(" ", "");
        src = src.substring(3, src.length() - 1);

        proceedScopedExpression(src, ifLabel);
        methodVisitor.visitLabel(ifLabel);
    }

    public void proceedForCycle(String src) {
        Label forLabel = new Label();
        Label beginLabel = new Label();

        src = src.substring(3, src.length() - 2);
        src = src.replace("(new -> ", "");

        String[] keyValue = src.split(";");

        if (keyValue.length != 3) {
            throw new CompilationError("Incorrect for cycle");
        }

        evaluateIntValue(keyValue[0]);

        methodVisitor.visitLabel(beginLabel);
        proceedScopedExpression(keyValue[1], forLabel);
        assignVariable(keyValue[2]);

        methodVisitor.visitJumpInsn(Opcodes.GOTO, beginLabel);
        methodVisitor.visitLabel(forLabel);
    }

    public void proceedWhileCycle(String src) {
        Label whileLabel = new Label();
        Label beginLabel = new Label();

        src = src.substring(7, src.length() - 2);

        methodVisitor.visitLabel(beginLabel);
        proceedScopedExpression(src, whileLabel);

        methodVisitor.visitJumpInsn(Opcodes.GOTO, beginLabel);
        methodVisitor.visitLabel(whileLabel);
    }

    public void createLabel(String src) {
        src = src.replace("#", "");
        src = src.trim();

        if (src.split(" ").length != 1) {
            throw new CompilationError("Incorrect label: " + src);
        }

        Label label = new Label();

        methodVisitor.visitLabel(label);
        labelsPool.put(src, label);
    }

    public void proceedGoto(String src) {
        src = src.replace("goto", "");
        src = src.trim();

        if (src.split(" ").length != 1) {
            throw new CompilationError("Incorrect label: " + src);
        }

        methodVisitor.visitJumpInsn(Opcodes.GOTO, labelsPool.get(src));
    }

    @SneakyThrows
    public void processCompilation() {
        boolean isIncorrectInstruction;

        while (true) {
            isIncorrectInstruction = true;

            String stringLine = inputFile.readLine();

            if (stringLine == null || stringLine.equals("}"))
                return;

            stringLine = stringLine.trim();

            if (stringLine.isEmpty())
                continue;

            if (!(stringLine.endsWith(";") || stringLine.endsWith("}") || stringLine.endsWith("{"))) {
                throw new CompilationError("Incorrect line ending");
            }

            stringLine = stringLine.substring(0, stringLine.length() - 1);

            if (Pattern.matches(regularExpressionTemplate.getVariableInitializationTemplate(), stringLine)) {
                evaluateIntValue(stringLine);
                isIncorrectInstruction = false;
            }
            if (Pattern.matches(regularExpressionTemplate.getValueAssignmentTemplate(), stringLine)) {
                assignVariable(stringLine);
                isIncorrectInstruction = false;
            }
            if (Pattern.matches(regularExpressionTemplate.getLabelTemplate(), stringLine)) {
                createLabel(stringLine);
                isIncorrectInstruction = false;
            }
            if (Pattern.matches(regularExpressionTemplate.getGotoTemplate(), stringLine)) {
                proceedGoto(stringLine);
                isIncorrectInstruction = false;
            }
            if (Pattern.matches(regularExpressionTemplate.getIfConditionTemplate(), stringLine)) {
                proceedIfCondition(stringLine);
                isIncorrectInstruction = false;
            }
            if (Pattern.matches(regularExpressionTemplate.getForCycleTemplate(), stringLine)) {
                proceedForCycle(stringLine);
                isIncorrectInstruction = false;
            }
            if (Pattern.matches(regularExpressionTemplate.getWhileCycleTemplate(), stringLine)) {
                proceedWhileCycle(stringLine);
                isIncorrectInstruction = false;
            }
            for (Function function : functions) {
                if (function.isMatching(stringLine)) {
                    function.process(stringLine);
                    isIncorrectInstruction = false;
                    break;
                }
            }
            if (isIncorrectInstruction) {
                throw new CompilationError("Bad instruction: " + stringLine);
            }
        }
    }

    @SneakyThrows
    public void writeToFile() {
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(1, variablesCounter);

        classWriter.visitEnd();

        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/CompiledApplication.class");
        fileOutputStream.write(classWriter.toByteArray());
    }

    public void incrementVariablesCounter() {
        variablesCounter++;
    }
}
