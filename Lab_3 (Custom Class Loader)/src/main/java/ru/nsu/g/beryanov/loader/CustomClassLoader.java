package ru.nsu.g.beryanov.loader;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class CustomClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData(name);
        String[] splitPath = name.split("/");
        return defineClass("ru.nsu.g.beryanov." + splitPath[splitPath.length - 1], bt, 0, bt.length);
    }

    @SneakyThrows
    private byte[] loadClassData(String className) {
        InputStream classDataInputStream = new FileInputStream(className + ".class");
        ByteArrayOutputStream classDataByteStream = new ByteArrayOutputStream();

        int readAmount;
        while ((readAmount = classDataInputStream.read()) != -1) {
            classDataByteStream.write(readAmount);
        }

        return classDataByteStream.toByteArray();
    }
}
