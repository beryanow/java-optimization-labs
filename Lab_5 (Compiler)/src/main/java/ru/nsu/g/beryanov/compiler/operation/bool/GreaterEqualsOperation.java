package ru.nsu.g.beryanov.compiler.operation.bool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ru.nsu.g.beryanov.compiler.processing.Compiler;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

@Component
@Order(2)
public class GreaterEqualsOperation implements BooleanOperation {
    @Value(">=")
    public String tag;

    @Autowired
    public Compiler compiler;

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public void jump(Label label) {
        compiler.getMethodVisitor().visitJumpInsn(Opcodes.IF_ICMPLT, label);
    }
}