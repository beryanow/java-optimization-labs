package ru.nsu.g.beryanov.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConstantTag {
    public final byte UTF8 = 0x1;
    public final byte INTEGER = 0x3;
    public final byte FLOAT = 0x4;
    public final byte LONG = 0x5;
    public final byte DOUBLE = 0x6;
    public final byte CLASS = 0x7;
    public final byte STRING = 0x8;
    public final byte FIELD_REFERENCE = 0x9;
    public final byte METHOD_REFERENCE = 0xA;
    public final byte INTERFACE_METHOD_REFERENCE = 0xB;
    public final byte NAME_AND_TYPE = 0xC;
    public final byte METHOD_HANDLE = 0xF;
    public final byte METHOD_TYPE = 0x10;
    public final byte DYNAMIC = 0x11;
    public final byte INVOKE_DYNAMIC = 0x12;
    public final byte MODULE = 0x13;
    public final byte PACKAGE = 0x14;
}
