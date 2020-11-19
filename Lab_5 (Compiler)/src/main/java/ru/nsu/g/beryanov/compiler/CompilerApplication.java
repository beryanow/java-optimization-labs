package ru.nsu.g.beryanov.compiler;

import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.nsu.g.beryanov.compiler.processing.Compiler;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
public class CompilerApplication implements CommandLineRunner {
    @Autowired
    private Compiler compiler;

    public static void main(String[] args) {
        SpringApplication.run(CompilerApplication.class, args);
    }

    @Override
    @SneakyThrows
    public void run(String... args) {
        compiler.setInputFile(new BufferedReader(new FileReader("src/main/resources/instructions.txt")));
        compiler.processCompilation();
        compiler.writeToFile();
    }
}
