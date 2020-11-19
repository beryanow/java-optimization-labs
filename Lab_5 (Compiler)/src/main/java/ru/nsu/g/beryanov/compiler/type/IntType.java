package ru.nsu.g.beryanov.compiler.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.nsu.g.beryanov.compiler.exception.CompilationError;
import ru.nsu.g.beryanov.compiler.processing.Compiler;

import org.objectweb.asm.Opcodes;

@Component(value = "intType")
@Scope("prototype")
public class IntType implements PrimitiveType {
    @Value("int")
    public String typeName;

    @Autowired
    private Compiler compiler;

    @Autowired
    private ApplicationContext appCxt;

    @Override
    public PrimitiveType copyVariable() {
        return (IntType) appCxt.getBean("intType");
    }

    int mark = -1;

    @Override
    public String getTypeName() {
        return typeName;
    }

    @Override
    public Integer getMark() {
        return mark;
    }

    @Override
    public String getAsmTypeName() {
        return "I";
    }

    @Override
    public void addValueToPool(String src) {
        Integer value = Integer.parseInt(src);

        compiler.getClassWriter().newConst(value);
        compiler.getMethodVisitor().visitLdcInsn(value);
    }

    @Override
    public void getValueFromPool(String varName, String expectedType) throws CompilationError {
        if(!expectedType.equals(typeName)) {
            throw new CompilationError("Incorrect type: " + varName);
        }

        compiler.getMethodVisitor().visitVarInsn(Opcodes.ILOAD, compiler.getVariablesPool().get(varName).getMark());
    }

    @Override
    public void putExistingVariableToPool(String varName) {
        compiler.getMethodVisitor().visitVarInsn(Opcodes.ISTORE, compiler.getVariablesPool().get(varName).getMark());
    }

    @Override
    public void saveVariable(String varName) {
        compiler.getMethodVisitor().visitVarInsn(Opcodes.ISTORE, compiler.getVariablesCounter());
        mark = compiler.getVariablesCounter();

        compiler.getVariablesPool().put(varName, this);
        compiler.incrementVariablesCounter();
    }
}
