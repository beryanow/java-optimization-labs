package ru.nsu.g.beryanov.compiler.operation.bool;

import org.objectweb.asm.Label;

public interface BooleanOperation {
    String getTag();
    void jump(Label label);
}
