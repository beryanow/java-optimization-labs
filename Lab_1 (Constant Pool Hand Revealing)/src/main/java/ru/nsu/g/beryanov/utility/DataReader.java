package ru.nsu.g.beryanov.utility;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class DataReader {
    @SneakyThrows
    public byte readOneByte(FileInputStream fileInputStream) {
        byte[] bytes = new byte[1];

        fileInputStream.read(bytes);

        return bytes[0];
    }

    @SneakyThrows
    public short readTwoBytes(FileInputStream fileInputStream) {
        byte[] bytes = new byte[2];

        fileInputStream.read(bytes);

        short value = 0;
        for (int i = 0; i < 2; i++) {
            value <<= 8;
            value |= bytes[i] & 0xFF;
        }

        return value;
    }

    @SneakyThrows
    public int readFourBytes(FileInputStream fileInputStream) {
        byte[] bytes = new byte[4];

        fileInputStream.read(bytes);

        int value = 0;
        for (int i = 0; i < 8; i++) {
            value <<= 8;
            value |= bytes[i] & 0xFF;
        }

        return value;
    }

    @SneakyThrows
    public long readEightBytes(FileInputStream fileInputStream) {
        byte[] bytes = new byte[8];

        fileInputStream.read(bytes);

        long value = 0;
        for (int i = 0; i < 8; i++) {
            value <<= 8;
            value |= bytes[i] & 0xFF;
        }

        return value;
    }
}
