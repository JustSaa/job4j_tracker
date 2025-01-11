package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FactorialTest {

    @Test
    void whenInputNumberIsInvalidThrowsIllegalArgumentException() {
        int inputNumber = -1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Factorial().calc(inputNumber));
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    void whenInputNumberIsValid() {
        int inputNumber = 3;
        int exceptValue = 6;
        int result = new Factorial().calc(inputNumber);
        assertThat(result).isEqualTo(exceptValue);
    }
}