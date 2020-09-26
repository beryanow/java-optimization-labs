package ru.nsu.g.beryanov.configuration;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsmClassGenerationConfiguration {
    @Bean(value = "classWriter")
    public ClassWriter classWriter() {
        return new ClassWriter(0);
    }

    @Bean(value = "methodVisitor")
    public MethodVisitor methodVisitor() {
        return classWriter().visitMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "main", "([Ljava/lang/String;)V", null, null); // public static void main(String[])
    }

    @Bean(value = "label0")
    public Label label0() {
        return new Label();
    }

    @Bean(value = "label4")
    public Label label4() {
        return new Label();
    }

    @Bean(value = "label10")
    public Label label10() {
        return new Label();
    }

    @Bean(value = "label14")
    public Label label14() {
        return new Label();
    }

    @Bean(value = "label17")
    public Label label17() {
        return new Label();
    }

    @Bean(value = "label22")
    public Label label22() {
        return new Label();
    }

    @Bean(value = "label25")
    public Label label25() {
        return new Label();
    }

    @Bean(value = "label30")
    public Label label30() {
        return new Label();
    }

    @Bean(value = "label35")
    public Label label35() {
        return new Label();
    }
}
