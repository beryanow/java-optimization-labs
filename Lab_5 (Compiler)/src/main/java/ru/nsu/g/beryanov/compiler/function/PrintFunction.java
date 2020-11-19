package ru.nsu.g.beryanov.compiler.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.nsu.g.beryanov.compiler.exception.CompilationError;
import ru.nsu.g.beryanov.compiler.processing.Compiler;
import ru.nsu.g.beryanov.compiler.type.PrimitiveType;

import org.objectweb.asm.Opcodes;

import java.util.regex.Pattern;

@Component
public class PrintFunction implements Function {
    @Autowired
    private Compiler compiler;

    @Override
    public boolean isMatching(String src) {
        return Pattern.matches(" *print .+ *", src);
    }

    @Override
    public void process(String src) throws CompilationError {
        compiler.getMethodVisitor().visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        String[] values = src.split("print -> ");

        String value = null;

        if (values.length > 2) {
            throw new CompilationError("Incorrect print");
        }

        if (values.length == 1) {
            value = values[0];
        }

        if (values.length == 2) {
            value = values[1];
        }

        PrimitiveType resultType = compiler.evaluateValue(value);

        compiler.getMethodVisitor().visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(" + resultType.getAsmTypeName() +")V", false);
    }
}
