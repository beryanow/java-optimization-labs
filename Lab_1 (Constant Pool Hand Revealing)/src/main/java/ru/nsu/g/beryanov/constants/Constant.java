package ru.nsu.g.beryanov.constants;

import lombok.Setter;
import lombok.ToString;

import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@Setter
public abstract class Constant {
    private byte tag;

    public abstract void readData(FileInputStream fileInputStream, DataReader dataReader);
    public abstract String getData();
}
