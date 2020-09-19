package ru.nsu.g.beryanov.constant.extension;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constant.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class ClassConstant extends Constant {
    private short nameIndex;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        nameIndex = dataReader.readTwoBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return new StringBuilder().append("#").append(String.valueOf(nameIndex)).toString();
    }
}


