package ru.nsu.g.beryanov;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.nsu.g.beryanov.service.GuessNumberService;

@SpringBootApplication
public class AsmClassGenerationApplication implements CommandLineRunner {
    @Autowired
    @Qualifier("classWriter")
    private ClassWriter classWriter;

    @Autowired
    @Qualifier("methodVisitor")
    private MethodVisitor methodVisitor;

    @Autowired
    private GuessNumberService guessNumberService;

    public static void main(String[] args) {
        SpringApplication.run(AsmClassGenerationApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        guessNumberService.generateClass(classWriter)
                .generateRandomConstant(classWriter)
                .inspectMainMethod(methodVisitor)
                .createGreetingMessage(methodVisitor)
                .initializeScanner(methodVisitor)
                .getPredictedValue(methodVisitor)
                .comparePredictedToRandomEqual(methodVisitor)
                .comparePredictedToRandomLess(methodVisitor)
                .createPredictGreaterMessage(methodVisitor)
                .createPredictLowerMessage(methodVisitor)
                .createPredictSuccessMessage(methodVisitor)
                .createConstantMapping(methodVisitor)
                .endVisiting(classWriter, methodVisitor)
                .createClassFile(classWriter);
    }
}
