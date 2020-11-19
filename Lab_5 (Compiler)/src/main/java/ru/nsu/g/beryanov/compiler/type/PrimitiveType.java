package ru.nsu.g.beryanov.compiler.type;

import ru.nsu.g.beryanov.compiler.exception.CompilationError;

public interface PrimitiveType {
    PrimitiveType copyVariable();
    String getTypeName();
    Integer getMark();
    String getAsmTypeName();

    void addValueToPool(String src);
    void getValueFromPool(String varName, String expectedType) throws CompilationError;
    void putExistingVariableToPool(String varName);
    void saveVariable(String varName);
}
