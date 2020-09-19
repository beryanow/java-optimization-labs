package ru.nsu.g.beryanov.constants.extensions;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

public class PackageConstant extends Constant {
    private short nameIndex;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        nameIndex = dataReader.readTwoBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return new StringBuilder().append("#").append(nameIndex).toString();
    }
}

