package ru.nsu.g.beryanov.constants.extensions;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class MethodTypeConstant extends Constant {
    private short descriptorIndex;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        descriptorIndex = dataReader.readTwoBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return new StringBuilder().append("#").append(String.valueOf(descriptorIndex)).toString();
    }
}
