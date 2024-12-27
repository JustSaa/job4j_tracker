package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус уехал");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В атобусе:" + count);
    }

    @Override
    public int refuel(int fuel) {
        return 0;
    }
}
