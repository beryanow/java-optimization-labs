package ru.nsu.g.beryanov.utility;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;

@Setter
@Getter
public class FileReader {
    private File file;
    private FileInputStream fileInputStream;
}
