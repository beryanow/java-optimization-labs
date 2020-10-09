package ru.nsu.g.beryanov.utility;

import lombok.Getter;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Getter
public class FileProcessor {
    File directory;
    File[] classFiles;

    public void revealDirectoryFiles(String directoryName) {
        directory = new File(directoryName);
        classFiles = directory.listFiles();
    }
}
