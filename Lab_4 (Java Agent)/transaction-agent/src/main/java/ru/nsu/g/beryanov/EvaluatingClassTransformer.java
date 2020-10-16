package ru.nsu.g.beryanov;


import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class EvaluatingClassTransformer implements ClassFileTransformer, Opcodes {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (className.equals("ru/nsu/g/beryanov/TransactionProcessor")) {
            ClassWriter classWriter = new ClassWriter(0);
            FieldVisitor fieldVisitor;
            MethodVisitor methodVisitor;

            classWriter.visit(V11, ACC_PUBLIC | ACC_SUPER, "ru/nsu/g/beryanov/TransactionProcessor", null, "java/lang/Object", null);
            classWriter.visitSource("TransactionProcessor.java", null);
            classWriter.visitInnerClass("java/lang/invoke/MethodHandles$Lookup", "java/lang/invoke/MethodHandles", "Lookup", ACC_PUBLIC | ACC_FINAL | ACC_STATIC);

            fieldVisitor = classWriter.visitField(ACC_STATIC, "minTime", "J", null, null);
            fieldVisitor.visitEnd();

            fieldVisitor = classWriter.visitField(ACC_STATIC, "maxTime", "J", null, null);
            fieldVisitor.visitEnd();

            fieldVisitor = classWriter.visitField(ACC_STATIC, "averageTime", "J", null, null);
            fieldVisitor.visitEnd();

            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            methodVisitor.visitCode();

            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            methodVisitor.visitInsn(RETURN);

            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLocalVariable("this", "Lru/nsu/g/beryanov/TransactionProcessor;", null, label0, label1, 0);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "processTransaction", "(I)V", null, new String[]{"java/lang/Exception"});
            methodVisitor.visitCode();

            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitIincInsn(1, 99);

            Label label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            methodVisitor.visitVarInsn(LSTORE, 2);

            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "err", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(ILOAD, 1);
            methodVisitor.visitInvokeDynamicInsn("makeConcatWithConstants", "(I)Ljava/lang/String;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "Processing tx: \u0001");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            Label label5 = new Label();
            methodVisitor.visitLabel(label5);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/Math", "random", "()D", false);
            methodVisitor.visitLdcInsn(1000.0);
            methodVisitor.visitInsn(DMUL);
            methodVisitor.visitInsn(D2I);
            methodVisitor.visitVarInsn(ISTORE, 4);

            Label label6 = new Label();
            methodVisitor.visitLabel(label6);
            methodVisitor.visitVarInsn(ILOAD, 4);
            methodVisitor.visitInsn(I2L);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/Thread", "sleep", "(J)V", false);

            Label label7 = new Label();
            methodVisitor.visitLabel(label7);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "err", "Ljava/io/PrintStream;");
            methodVisitor.visitLdcInsn("tx: %d completed");
            methodVisitor.visitInsn(ICONST_1);
            methodVisitor.visitTypeInsn(ANEWARRAY, "java/lang/Object");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitVarInsn(ILOAD, 1);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
            methodVisitor.visitInsn(AASTORE);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/String", "format", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", false);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            Label label8 = new Label();
            methodVisitor.visitLabel(label8);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            methodVisitor.visitVarInsn(LLOAD, 2);
            methodVisitor.visitInsn(LSUB);
            methodVisitor.visitVarInsn(LSTORE, 5);

            Label label9 = new Label();
            methodVisitor.visitLabel(label9);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(LLOAD, 5);
            methodVisitor.visitInvokeDynamicInsn("makeConcatWithConstants", "(J)Ljava/lang/String;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "Transaction processing took \u0001 ms.");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            Label label10 = new Label();
            methodVisitor.visitLabel(label10);
            methodVisitor.visitVarInsn(LLOAD, 5);
            methodVisitor.visitFieldInsn(GETSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "minTime", "J");
            methodVisitor.visitInsn(LCMP);

            Label label11 = new Label();
            methodVisitor.visitJumpInsn(IFGE, label11);

            Label label12 = new Label();
            methodVisitor.visitLabel(label12);
            methodVisitor.visitVarInsn(LLOAD, 5);
            methodVisitor.visitFieldInsn(PUTSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "minTime", "J");
            methodVisitor.visitLabel(label11);
            methodVisitor.visitFrame(Opcodes.F_APPEND, 3, new Object[]{Opcodes.LONG, Opcodes.INTEGER, Opcodes.LONG}, 0, null);
            methodVisitor.visitVarInsn(LLOAD, 5);
            methodVisitor.visitFieldInsn(GETSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "maxTime", "J");
            methodVisitor.visitInsn(LCMP);

            Label label13 = new Label();
            methodVisitor.visitJumpInsn(IFLE, label13);

            Label label14 = new Label();
            methodVisitor.visitLabel(label14);
            methodVisitor.visitVarInsn(LLOAD, 5);
            methodVisitor.visitFieldInsn(PUTSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "maxTime", "J");
            methodVisitor.visitLabel(label13);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitFieldInsn(GETSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "averageTime", "J");
            methodVisitor.visitVarInsn(LLOAD, 5);
            methodVisitor.visitInsn(LADD);
            methodVisitor.visitFieldInsn(PUTSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "averageTime", "J");

            Label label15 = new Label();
            methodVisitor.visitLabel(label15);
            methodVisitor.visitInsn(RETURN);

            Label label16 = new Label();
            methodVisitor.visitLabel(label16);
            methodVisitor.visitLocalVariable("this", "Lru/nsu/g/beryanov/TransactionProcessor;", null, label2, label16, 0);
            methodVisitor.visitLocalVariable("txNum", "I", null, label2, label16, 1);
            methodVisitor.visitLocalVariable("start", "J", null, label4, label16, 2);
            methodVisitor.visitLocalVariable("sleep", "I", null, label6, label16, 4);
            methodVisitor.visitLocalVariable("time", "J", null, label9, label16, 5);
            methodVisitor.visitMaxs(6, 7);
            methodVisitor.visitEnd();
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, new String[]{"java/lang/Exception"});
            methodVisitor.visitCode();

            Label label17 = new Label();
            methodVisitor.visitLabel(label17);
            methodVisitor.visitTypeInsn(NEW, "ru/nsu/g/beryanov/TransactionProcessor");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "ru/nsu/g/beryanov/TransactionProcessor", "<init>", "()V", false);
            methodVisitor.visitVarInsn(ASTORE, 1);

            Label label18 = new Label();
            methodVisitor.visitLabel(label18);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitVarInsn(ISTORE, 2);

            Label label19 = new Label();
            methodVisitor.visitLabel(label19);
            methodVisitor.visitFrame(Opcodes.F_APPEND, 2, new Object[]{"ru/nsu/g/beryanov/TransactionProcessor", Opcodes.INTEGER}, 0, null);
            methodVisitor.visitVarInsn(ILOAD, 2);
            methodVisitor.visitIntInsn(BIPUSH, 10);

            Label label20 = new Label();
            methodVisitor.visitJumpInsn(IF_ICMPGE, label20);

            Label label21 = new Label();
            methodVisitor.visitLabel(label21);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ILOAD, 2);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "ru/nsu/g/beryanov/TransactionProcessor", "processTransaction", "(I)V", false);

            Label label22 = new Label();
            methodVisitor.visitLabel(label22);
            methodVisitor.visitIincInsn(2, 1);
            methodVisitor.visitJumpInsn(GOTO, label19);
            methodVisitor.visitLabel(label20);
            methodVisitor.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitFieldInsn(GETSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "maxTime", "J");
            methodVisitor.visitInvokeDynamicInsn("makeConcatWithConstants", "(J)Ljava/lang/String;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "Maximum transaction processing took \u0001 ms.");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            Label label23 = new Label();
            methodVisitor.visitLabel(label23);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitFieldInsn(GETSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "minTime", "J");
            methodVisitor.visitInvokeDynamicInsn("makeConcatWithConstants", "(J)Ljava/lang/String;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "Minimum transaction processing took \u0001 ms.");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            Label label24 = new Label();
            methodVisitor.visitLabel(label24);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitFieldInsn(GETSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "averageTime", "J");
            methodVisitor.visitInsn(L2D);
            methodVisitor.visitLdcInsn(10.0);
            methodVisitor.visitInsn(DDIV);
            methodVisitor.visitInvokeDynamicInsn("makeConcatWithConstants", "(D)Ljava/lang/String;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "Average transaction processing took \u0001 ms.");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            Label label25 = new Label();
            methodVisitor.visitLabel(label25);
            methodVisitor.visitInsn(RETURN);

            Label label26 = new Label();
            methodVisitor.visitLabel(label26);
            methodVisitor.visitLocalVariable("i", "I", null, label19, label20, 2);
            methodVisitor.visitLocalVariable("args", "[Ljava/lang/String;", null, label17, label26, 0);
            methodVisitor.visitLocalVariable("tp", "Lru/nsu/g/beryanov/TransactionProcessor;", null, label18, label26, 1);
            methodVisitor.visitMaxs(5, 3);
            methodVisitor.visitEnd();
            methodVisitor = classWriter.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
            methodVisitor.visitCode();

            Label label27 = new Label();
            methodVisitor.visitLabel(label27);
            methodVisitor.visitLdcInsn(2147483647L);
            methodVisitor.visitFieldInsn(PUTSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "minTime", "J");

            Label label28 = new Label();
            methodVisitor.visitLabel(label28);
            methodVisitor.visitLdcInsn(-2147483648L);
            methodVisitor.visitFieldInsn(PUTSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "maxTime", "J");

            Label label29 = new Label();
            methodVisitor.visitLabel(label29);
            methodVisitor.visitInsn(LCONST_0);
            methodVisitor.visitFieldInsn(PUTSTATIC, "ru/nsu/g/beryanov/TransactionProcessor", "averageTime", "J");
            methodVisitor.visitInsn(RETURN);
            methodVisitor.visitMaxs(2, 0);
            methodVisitor.visitEnd();
            classWriter.visitEnd();

            return classWriter.toByteArray();
        } else {
            return classfileBuffer;
        }
    }
}
