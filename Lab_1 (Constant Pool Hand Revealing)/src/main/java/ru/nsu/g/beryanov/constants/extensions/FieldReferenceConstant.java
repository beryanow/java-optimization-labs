package ru.nsu.g.beryanov.constants.extensions;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class FieldReferenceConstant extends Constant {
    private short classIndex;
    private short nameAndTypeIndex;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        classIndex = dataReader.readTwoBytes(fileInputStream);
        nameAndTypeIndex = dataReader.readTwoBytes(fileInputStream);
    }

    @Override
    public String getData() {
        return new StringBuilder().append("#").append(String.valueOf(classIndex)).append(" #").append(String.valueOf(nameAndTypeIndex)).toString();
    }
}
