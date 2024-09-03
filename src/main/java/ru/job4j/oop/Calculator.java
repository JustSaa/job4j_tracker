package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        int resultMinus = Calculator.minus(10);
        System.out.println(resultMinus);
        Calculator calculator = new Calculator();
        int resultDivide = calculator.divide(10);
        System.out.println(resultDivide);
        int resultSum = calculator.sumAllOperation(10);
        System.out.println(resultSum);
    }
}