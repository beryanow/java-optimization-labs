package ru.nsu.g.beryanov.constants.extensions;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class IntegerConstant extends Constant {
    private int bytes;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        bytes = dataReader.readFourBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return String.valueOf(bytes);
    }
}
