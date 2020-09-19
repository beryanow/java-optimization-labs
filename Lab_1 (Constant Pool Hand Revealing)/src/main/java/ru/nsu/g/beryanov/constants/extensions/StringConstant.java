package ru.nsu.g.beryanov.constants.extensions;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class StringConstant extends Constant {
    private short stringIndex;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        stringIndex = dataReader.readTwoBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return new StringBuilder().append("#").append(String.valueOf(stringIndex)).toString();
    }
}
