package ru.nsu.g.beryanov.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.nsu.g.beryanov.constants.Constant;
import ru.nsu.g.beryanov.constants.ConstantTag;
import ru.nsu.g.beryanov.constants.extensions.ClassConstant;
import ru.nsu.g.beryanov.constants.extensions.DoubleConstant;
import ru.nsu.g.beryanov.constants.extensions.DynamicConstant;
import ru.nsu.g.beryanov.constants.extensions.FieldReferenceConstant;
import ru.nsu.g.beryanov.constants.extensions.FloatConstant;
import ru.nsu.g.beryanov.constants.extensions.IntegerConstant;
import ru.nsu.g.beryanov.constants.extensions.InterfaceMethodReferenceConstant;
import ru.nsu.g.beryanov.constants.extensions.InvokeDynamicConstant;
import ru.nsu.g.beryanov.constants.extensions.LongConstant;
import ru.nsu.g.beryanov.constants.extensions.MethodHandleConstant;
import ru.nsu.g.beryanov.constants.extensions.MethodReferenceConstant;
import ru.nsu.g.beryanov.constants.extensions.MethodTypeConstant;
import ru.nsu.g.beryanov.constants.extensions.ModuleConstant;
import ru.nsu.g.beryanov.constants.extensions.NameAndTypeConstant;
import ru.nsu.g.beryanov.constants.extensions.PackageConstant;
import ru.nsu.g.beryanov.constants.extensions.StringConstant;
import ru.nsu.g.beryanov.constants.extensions.UTF8Constant;
import ru.nsu.g.beryanov.utility.DataReader;

import java.io.FileInputStream;
import java.util.ArrayList;

@Slf4j
@Service
public class ConstantPoolAnalyzer {
    private final DataReader dataReader;

    @Autowired
    public ConstantPoolAnalyzer(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    @SneakyThrows
    public void missMagicNumber(FileInputStream fileInputStream) {
        fileInputStream.read(new byte[4]);
    }

    @SneakyThrows
    public short[] getVersions(FileInputStream fileInputStream) {
        short minorVersion = dataReader.readTwoBytes(fileInputStream);
        short majorVersion = dataReader.readTwoBytes(fileInputStream);

        return new short[]{minorVersion, majorVersion};
    }

    @SneakyThrows
    public short getConstantPoolCount(FileInputStream fileInputStream) {
        return dataReader.readTwoBytes(fileInputStream);
    }

    public Constant retrieveConstant(byte tag, FileInputStream fileInputStream) {
        Constant constant = null;

        switch (tag) {
            case ConstantTag.UTF8 -> {
                constant = new UTF8Constant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.INTEGER -> {
                constant = new IntegerConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.FLOAT -> {
                constant = new FloatConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.LONG -> {
                constant = new LongConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.DOUBLE -> {
                constant = new DoubleConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.CLASS -> {
                constant = new ClassConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.STRING -> {
                constant = new StringConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.FIELD_REFERENCE -> {
                constant = new FieldReferenceConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.METHOD_REFERENCE -> {
                constant = new MethodReferenceConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.INTERFACE_METHOD_REFERENCE -> {
                constant = new InterfaceMethodReferenceConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.NAME_AND_TYPE -> {
                constant = new NameAndTypeConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.METHOD_HANDLE -> {
                constant = new MethodHandleConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.METHOD_TYPE -> {
                constant = new MethodTypeConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.DYNAMIC -> {
                constant = new DynamicConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.INVOKE_DYNAMIC -> {
                constant = new InvokeDynamicConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.MODULE -> {
                constant = new ModuleConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
            case ConstantTag.PACKAGE -> {
                constant = new PackageConstant();
                constant.setTag(tag);
                constant.readData(fileInputStream, dataReader);
            }
        }

        return constant;
    }

    public ArrayList<Constant> getConstantPool(FileInputStream fileInputStream, short constantPoolCount) {
        ArrayList<Constant> constantArrayList = new ArrayList<>();

        for (short i = 0; i < constantPoolCount; i++) {
            byte tag = dataReader.readOneByte(fileInputStream);

            Constant constant = retrieveConstant(tag, fileInputStream);
            constantArrayList.add(constant);
        }

        return constantArrayList;
    }

    public void showResult(short majorVersion, short minorVersion, short constantPoolCount, ArrayList<Constant> constantArrayList) {
        log.info(new StringBuilder().append("Class file format version: ").append(majorVersion).append(".").append(minorVersion).toString());

        for (int i = 0; i < constantPoolCount; i++) {
            log.info(new StringBuilder().append("#").append(i + 1).append(" ").append(constantArrayList.get(i).getClass().getSimpleName().split("Constant")[0]).append(" : ").append(constantArrayList.get(i).getData()).toString());
        }
    }
}
