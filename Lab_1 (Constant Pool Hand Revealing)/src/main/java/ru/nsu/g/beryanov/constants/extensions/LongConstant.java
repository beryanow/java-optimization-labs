package ru.nsu.g.beryanov.constants.extensions;

import lombok.Getter;
import lombok.ToString;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Getter
public class LongConstant extends Constant {
    private int highBytes;
    private int lowBytes;

    private long bytes;

    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        highBytes = dataReader.readFourBytes(fileInputStream);
        lowBytes = dataReader.readFourBytes(fileInputStream);

        bytes = ((long) highBytes << 32) + lowBytes;
    }

    @Override
    public String getData() {
        return String.valueOf(bytes);
    }
}
