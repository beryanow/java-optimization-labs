package ru.nsu.g.beryanov.constants;

import com.google.common.collect.ImmutableMap;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MethodHandleKind {
    public final byte REFERENCE_GET_FIELD = 0x1;
    public final byte REFERENCE_GET_STATIC = 0x2;
    public final byte REFERENCE_PUT_FIELD = 0x3;
    public final byte REFERENCE_PUT_STATIC = 0x4;
    public final byte REFERENCE_INVOKE_VIRTUAL = 0x5;
    public final byte REFERENCE_INVOKE_STATIC = 0x6;
    public final byte REFERENCE_INVOKE_SPECIAL = 0x7;
    public final byte REFERENCE_NEW_INVOKE_SPECIAL = 0x8;
    public final byte REFERENCE_INVOKE_INTERFACE = 0x9;

    public final ImmutableMap<Byte, String> methodHandleKinds =
            ImmutableMap.<Byte, String>builder()
                    .put(REFERENCE_GET_FIELD, "REFERENCE_GET_FIELD")
                    .put(REFERENCE_GET_STATIC, "REFERENCE_GET_STATIC")
                    .put(REFERENCE_PUT_FIELD, "REFERENCE_PUT_FIELD")
                    .put(REFERENCE_PUT_STATIC, "REFERENCE_PUT_STATIC")
                    .put(REFERENCE_INVOKE_VIRTUAL, "REFERENCE_INVOKE_VIRTUAL")
                    .put(REFERENCE_INVOKE_STATIC, "REFERENCE_INVOKE_STATIC")
                    .put(REFERENCE_INVOKE_SPECIAL, "REFERENCE_INVOKE_SPECIAL")
                    .put(REFERENCE_NEW_INVOKE_SPECIAL, "REFERENCE_NEW_INVOKE_SPECIAL")
                    .put(REFERENCE_INVOKE_INTERFACE, "REFERENCE_INVOKE_INTERFACE")
                    .build();

}
