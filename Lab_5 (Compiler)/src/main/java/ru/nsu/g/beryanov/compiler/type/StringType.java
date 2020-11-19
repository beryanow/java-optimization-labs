package ru.nsu.g.beryanov.compiler.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.nsu.g.beryanov.compiler.exception.CompilationError;
import ru.nsu.g.beryanov.compiler.processing.Compiler;

import org.objectweb.asm.Opcodes;

@Component(value = "stringType")
@Scope("prototype")
public class StringType implements PrimitiveType {
    @Value("str")
    public String typeName;

    @Autowired
    private Compiler compiler;

    @Autowired
    private ApplicationContext appCxt;

    int mark = -1;

    @Override
    public PrimitiveType copyVariable() {
        return (StringType) appCxt.getBean("stringType");
    }

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
        return "Ljava/lang/String;";
    }

    @Override
    public void addValueToPool(String src) {
        compiler.getClassWriter().newConst(src);
        compiler.getMethodVisitor().visitLdcInsn(src);
    }

    @Override
    public void getValueFromPool(String varName, String expectedType) throws CompilationError {
        if(!expectedType.equals(typeName))
            throw new CompilationError("Incorrect type: " + varName);

        compiler.getMethodVisitor().visitVarInsn(Opcodes.ALOAD, compiler.getVariablesPool().get(varName).getMark());
    }

    @Override
    public void putExistingVariableToPool(String varName) {
        compiler.getMethodVisitor().visitVarInsn(Opcodes.ASTORE, compiler.getVariablesPool().get(varName).getMark());
    }

    @Override
    public void saveVariable(String varName) {
        compiler.getMethodVisitor().visitVarInsn(Opcodes.ASTORE, compiler.getVariablesCounter());
        mark = compiler.getVariablesCounter();

        compiler.getVariablesPool().put(varName, this);
        compiler.incrementVariablesCounter();
    }
}
