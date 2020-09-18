package ru.nsu.g.beryanov.constant;

import lombok.Setter;
import lombok.ToString;

import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;

@ToString
@Setter
public abstract class Constant {
    private byte tag;

    public abstract void readData(FileInputStream fileInputStream, DataReader dataReader);
    public abstract String getData();
}
