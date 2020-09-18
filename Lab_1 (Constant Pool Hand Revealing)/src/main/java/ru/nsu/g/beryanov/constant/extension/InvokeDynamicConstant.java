package ru.nsu.g.beryanov.constant.extension;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constant.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class InvokeDynamicConstant extends Constant {
    private short bootstrapMethodAttributeIndex;
    private short nameAndTypeIndex;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        bootstrapMethodAttributeIndex = dataReader.readTwoBytes(fileInputStream);
        nameAndTypeIndex = dataReader.readTwoBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return new StringBuilder().append("#").append(String.valueOf(bootstrapMethodAttributeIndex)).append(" #").append(String.valueOf(nameAndTypeIndex)).toString();
    }
}
