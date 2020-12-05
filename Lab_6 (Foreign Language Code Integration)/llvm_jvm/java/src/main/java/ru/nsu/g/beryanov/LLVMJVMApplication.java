package ru.nsu.g.beryanov;

import java.io.File;
import java.io.IOException;

import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class LLVMJVMApplication {
    public static void main(String[] args) throws IOException {
        Context c = Context.newBuilder().allowNativeAccess(true).allowIO(true).build();
        Source s = Source.newBuilder("llvm", new File("src/main/resources/CPUInfo.bc")).build();
        Value lib = c.eval(s);
        Value fn = lib.getMember("showCPUInfo");
        fn.executeVoid();
    }
}
