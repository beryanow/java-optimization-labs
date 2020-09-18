package ru.nsu.g.beryanov.constant.extension;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constant.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class FloatConstant extends Constant {
    private float value;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        value = dataReader.readFourBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return String.valueOf(value);
    }
}
