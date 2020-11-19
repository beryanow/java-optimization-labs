package ru.nsu.g.beryanov.compiler.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CompilationError extends RuntimeException {
    private String errorMessage;
}
