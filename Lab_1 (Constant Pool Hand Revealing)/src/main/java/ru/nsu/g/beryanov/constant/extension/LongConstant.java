package ru.nsu.g.beryanov.constant.extension;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constant.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class LongConstant extends Constant {
    private long value;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        value = dataReader.readEightBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return String.valueOf(value);
    }
}
