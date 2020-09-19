package ru.nsu.g.beryanov.constants.extensions;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.constants.MethodHandleKind;
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
        return new StringBuilder().append(MethodHandleKind.methodHandleKinds.get(referenceKind)).append(" #").append(String.valueOf(referenceIndex)).toString();
    }
}
