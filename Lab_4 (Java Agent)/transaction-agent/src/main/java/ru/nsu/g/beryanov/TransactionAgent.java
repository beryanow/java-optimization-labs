package ru.nsu.g.beryanov;

import java.lang.instrument.Instrumentation;

public class TransactionAgent {
    public static void premain(String agentArgument, Instrumentation instrumentation) {
        instrumentation.addTransformer(new ClassTransformer());
        instrumentation.addTransformer(new EvaluatingClassTransformer());
    }
}
