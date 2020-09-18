package ru.nsu.g.beryanov.constant.extension;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

import ru.nsu.g.beryanov.constant.Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

@ToString
@Getter
public class UTF8Constant extends Constant {
    private short length;
    private String value;

    @SneakyThrows
    @Override
    public void readData(FileInputStream fileInputStream, DataReader dataReader) {
        length = dataReader.readTwoBytes(fileInputStream);

        byte[] bytes = new byte[length];
        fileInputStream.read(bytes);

        value = new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String getData() {
        return value;
    }
}
