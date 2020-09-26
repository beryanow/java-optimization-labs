package ru.nsu.g.beryanov.service;

import lombok.SneakyThrows;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class GuessNumberService {
    @Autowired
    @Qualifier(value = "label0")
    private Label label0;

    @Autowired
    @Qualifier(value = "label4")
    private Label label4;

    @Autowired
    @Qualifier(value = "label10")
    private Label label10;

    @Autowired
    @Qualifier(value = "label14")
    private Label label14;

    @Autowired
    @Qualifier(value = "label17")
    private Label label17;

    @Autowired
    @Qualifier(value = "label22")
    private Label label22;

    @Autowired
    @Qualifier(value = "label25")
    private Label label25;

    @Autowired
    @Qualifier(value = "label30")
    private Label label30;

    @Autowired
    @Qualifier(value = "label35")
    private Label label35;

    public GuessNumberService generateClass(ClassWriter classWriter) {
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "ru/nsu/g/beryanov/GuessNumber", null, "java/lang/Object", null); // версия байткода 11.0
        return this;
    }

    public GuessNumberService generateRandomConstant(ClassWriter classWriter) {
        classWriter.visitField(Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "randomNumber", "I", null, (int) (Math.random() * 100)).visitEnd(); // диапазон рандомного значения: [0..100]
        return this;
    }

    public GuessNumberService inspectMainMethod(MethodVisitor methodVisitor) {
        methodVisitor.visitCode();
        return this;
    }

    public GuessNumberService createGreetingMessage(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label0); // метка 0
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); // инициализация класса (если не инициализирован) и помещение ссылки на поле этого класса на стек операндов
        methodVisitor.visitLdcInsn("I've thought a number, try to guess!"); // помещение ссылки на строку на стек операндов
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); // вызов метода вывода на экран
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4); // переход к метке 4
        return this;
    }

    public GuessNumberService initializeScanner(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label4); // метка 4
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Scanner"); // инициализация класса
        methodVisitor.visitInsn(Opcodes.DUP); // дублирование значения на стеке операндов
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;"); // инициализация класса (если не инициализирован) и помещение ссылки на поле этого класса на стек операндов
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false); // вызов конструктора класса сканера, изъятие аргумента со стека операндов, помещение получаемой ссылки на вершину стека операндов
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1); // помещение значения из вершины стека операндов в (первую) локальную переменную (ссылка на объект сканера)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10); // переход к метке 10
        return this;
    }

    public GuessNumberService getPredictedValue(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label10); // метка 10
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1); // помещение значения из (первой) локальной переменной на стек операндов (ссылка на упомянутый объект сканера)
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false); // вызов метода класса сканера, считывающего целочисленное значение, помещение результата на стек операндов
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2); // помещение значения из вершины стека операндов во (вторую) локальную переменную (считанное с консоли значение)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label14); // переход к метке 14
        return this;
    }

    public GuessNumberService comparePredictedToRandomEqual(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label14); // метка 14
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2); // помещение значения из (второй) локальной переменной на стек операндов (считанное значение)
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "ru/nsu/g/beryanov/GuessNumber", "randomNumber", "I"); // помещение значения поля randomNumber класса GuessNumber на стек операндов
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label17); // изъятие двух значений со стека операндов и их сравнение; переход к метке 17, если значения равны
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label22); // переход к метке 22
        return this;
    }

    public GuessNumberService comparePredictedToRandomLess(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label22); // метка 22
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2); // помещение значения из (второй) локальной переменной на стек операндов (считанное значение)
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "ru/nsu/g/beryanov/GuessNumber", "randomNumber", "I"); // помещение значения поля randomNumber класса GuessNumber на стек операндов
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLE, label25); // изъятие двух значений со стека операндов и их сравнение; переход к метке 25, если первое из них меньше второго
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label30); // переход к метке 30
        return this;
    }

    public GuessNumberService createPredictGreaterMessage(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label25); // метка 25
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); // инициализация класса (если не инициализирован) и помещение ссылки на поле этого класса на стек операндов
        methodVisitor.visitLdcInsn("Greater"); // помещение ссылки на строку на стек операндов
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); // вызов метода вывода на экран
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10); // переход к метке 10
        return this;
    }

    public GuessNumberService createPredictLowerMessage(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label30); // метка 30
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); // инициализация класса (если не инициализирован) и помещение ссылки на поле этого класса на стек операндов
        methodVisitor.visitLdcInsn("Lower"); // помещение ссылки на строку на стек операндов
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); // вызов метода вывода на экран
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10); // переход к метке 10
        return this;
    }

    public GuessNumberService createPredictSuccessMessage(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label17); // метка 17
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); // инициализация класса (если не инициализирован) и помещение ссылки на поле этого класса на стек операндов
        methodVisitor.visitLdcInsn("Exactly! Good bye!"); // помещение ссылки на строку на стек операндов
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); // вызов метода вывода на экран
        methodVisitor.visitInsn(Opcodes.RETURN); // выход из метода, очистка всех значений стека операндов текущего кадра
        return this;
    }

    public GuessNumberService createConstantMapping(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(label35); // метка 35
        methodVisitor.visitLocalVariable("args", "[Ljava/lang/String;", null, label0, label35, 0); // определение нулевой локальной переменной
        methodVisitor.visitLocalVariable("scanner", "Ljava/util/Scanner;", null, label0, label35, 1); // определение первой локальной переменной
        methodVisitor.visitLocalVariable("value", "I", null, label0, label30, 2); // определение второй локальной переменной
        methodVisitor.visitMaxs(3, 3); // определение максимальных размеров стека операндов и максимального количества локальных переменных текущего кадра
        return this;
    }

    public GuessNumberService endVisiting(ClassWriter classWriter, MethodVisitor methodVisitor) {
        methodVisitor.visitEnd();
        classWriter.visitEnd();
        return this;
    }

    @SneakyThrows
    public void createClassFile(ClassWriter classWriter) {
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/ru/nsu/g/beryanov/GuessNumber.class");
        byte[] strToBytes = classWriter.toByteArray();
        outputStream.write(strToBytes);
    }
}
