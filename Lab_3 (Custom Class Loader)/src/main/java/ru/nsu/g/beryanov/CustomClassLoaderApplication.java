package ru.nsu.g.beryanov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.nsu.g.beryanov.loader.CustomClassLoader;
import ru.nsu.g.beryanov.utility.FileProcessor;

import java.io.File;

import java.lang.reflect.Method;

@SpringBootApplication
public class CustomClassLoaderApplication implements CommandLineRunner {
    @Autowired
    FileProcessor fileProcessor;

    @Autowired
    CustomClassLoader customClassLoader;

    public static void main(String[] args) {
        SpringApplication.run(CustomClassLoaderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fileProcessor.revealDirectoryFiles(args[0]);
        for (File classFile : fileProcessor.getClassFiles()) {
            Class<?> loadedClass = customClassLoader.findClass(args[0] + classFile.getName().split("\\.")[0]);
            try {
                Method loadedClassMethod = loadedClass.getDeclaredMethod("getSecurityMessage");
                Object loadedClassInstance = loadedClass.getDeclaredConstructor().newInstance();
                loadedClassMethod.setAccessible(true);

                System.out.println(loadedClass.getName());
                System.out.println(loadedClassMethod.invoke(loadedClassInstance));
            } catch (NoSuchMethodException ignored) {}
        }
    }
}
