package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 8, x -> 2 * Math.pow(x, 2) + 1 * x - 5);
        List<Double> expected = Arrays.asList(-2D, 5D, 16D, 31D, 50D, 73D, 100D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(7, 10, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(128D, 256D, 512D);
        assertThat(result).containsAll(expected);
    }
}