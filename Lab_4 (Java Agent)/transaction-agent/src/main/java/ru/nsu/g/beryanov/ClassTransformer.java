package ru.nsu.g.beryanov;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.ArrayList;

public class ClassTransformer implements ClassFileTransformer {
    private static int count = 0;
    private final ArrayList<String> loadedClassNames = new ArrayList<>();

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        loadedClassNames.add(className.replaceAll("/", "."));
        count++;

        if (className.equals("java/lang/Shutdown$Lock")) {
            System.out.println("Overall amount of loaded into JVM classes: " + count + ".");
            for (String loadedClassName : loadedClassNames) {
                System.out.println(loadedClassName);
            }
        }

        return classfileBuffer;
    }
}
