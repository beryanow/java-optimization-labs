package ru.nsu.g.beryanov.constant.extension;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constant.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class MethodHandleConstant extends Constant {
    private byte referenceKind;
    private short referenceIndex;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        referenceKind = dataReader.readOneByte(fileInputStream);
        referenceIndex = dataReader.readTwoBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return new StringBuilder().append(String.valueOf(referenceKind)).append(" #").append(String.valueOf(referenceIndex)).toString();
    }
}
