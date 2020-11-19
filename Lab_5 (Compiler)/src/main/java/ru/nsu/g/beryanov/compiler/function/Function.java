package ru.nsu.g.beryanov.compiler.function;

import ru.nsu.g.beryanov.compiler.exception.CompilationError;

public interface Function {
    boolean isMatching(String src);
    void process(String src) throws CompilationError;
}
