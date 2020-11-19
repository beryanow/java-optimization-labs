package ru.nsu.g.beryanov.compiler.operation.numerical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ru.nsu.g.beryanov.compiler.processing.Compiler;

import org.objectweb.asm.Opcodes;

@Component
public class DivisionOperation implements NumericalOperation {
    @Value("/")
    public String tag;

    @Autowired
    public Compiler compiler;

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public void process() {
        compiler.getMethodVisitor().visitInsn(Opcodes.IDIV);
    }
}
