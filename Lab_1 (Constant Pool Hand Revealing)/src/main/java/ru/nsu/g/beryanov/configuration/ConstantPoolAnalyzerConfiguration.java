package ru.nsu.g.beryanov.configuration;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.nsu.g.beryanov.utility.FileReader;

import java.io.File;
import java.io.FileInputStream;

@Configuration
public class ConstantPoolAnalyzerConfiguration {
    @SneakyThrows
    @Bean
    public FileReader fileReader() {
        FileReader fileReader = new FileReader();

        File file = new File("src/main/resources/DataReader.class");
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
