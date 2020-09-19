package ru.nsu.g.beryanov.constants.extensions;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

@ToString
@Getter
public class UTF8Constant extends Constant {
    private short length;
    private byte[] bytes;

    private String bytesValue;

    @SneakyThrows
    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        length = dataReader.readTwoBytes(fileInputStream);

        byte[] bytes = new byte[length];
        fileInputStream.read(bytes);

        bytesValue = new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String getData() {
        return bytesValue;
    }
}
