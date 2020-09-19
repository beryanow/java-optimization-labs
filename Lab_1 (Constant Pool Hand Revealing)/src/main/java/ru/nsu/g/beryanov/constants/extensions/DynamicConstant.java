package ru.nsu.g.beryanov.constants.extensions;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

public class DynamicConstant extends Constant {
    private short bootstrapMethodAttributeIndex;
    private short nameAndTypeIndex;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        bootstrapMethodAttributeIndex = dataReader.readTwoBytes(fileInputStream);
        nameAndTypeIndex = dataReader.readTwoBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return new StringBuilder().append("#").append(bootstrapMethodAttributeIndex).append(" #").append(nameAndTypeIndex).toString();
    }
}
