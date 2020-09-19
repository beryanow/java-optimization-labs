package ru.nsu.g.beryanov.configuration;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.nsu.g.beryanov.utility.FileReader;

import java.io.File;
import java.io.FileInputStream;

@Configuration
public class ConstantPoolAnalyzerConfiguration {
    @Value("${class.path}")
    private String classPath;

    @SneakyThrows
    @Bean
    public FileReader fileReader() {
        FileReader fileReader = new FileReader();

        File file = new File(classPath);
        FileInputStream fileInputStream = new FileInputStream(file);

        fileReader.setFile(file);
        fileReader.setFileInputStream(fileInputStream);

        return fileReader;
    }

    @Bean
    public FileInputStream fileInputStream() {
        return fileReader().getFileInputStream();
    }
}
