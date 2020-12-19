package ru.nsu.g.beryanov.benchmarking;

import org.apache.commons.math3.exception.NotANumberException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class NumberRevealBenchmark {
    private final String stringNumber = "123456789";

    public boolean revealNumberByException() {
        boolean isNumber = true;
        try {
            Integer.parseInt(stringNumber);
        }
        catch (NotANumberException notANumberException) {
            isNumber = false;
        }
        return isNumber;
    }

    public boolean revealNumberByCharacter() {
        boolean isNumber = true;
        for (int i = 0; i < stringNumber.length(); i++) {
            if (!Character.isDigit(stringNumber.charAt(i))) {
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }

    public boolean revealNumberByRegularExpression() {
        return stringNumber.matches("^\\d+$");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testConversionThroughException(Blackhole blackhole) {
        blackhole.consume(revealNumberByException());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testPlainConversion(Blackhole blackhole) {
        blackhole.consume(revealNumberByCharacter());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testConversionThroughRegularExpression(Blackhole blackhole) {
        blackhole.consume(revealNumberByRegularExpression());
    }
}
