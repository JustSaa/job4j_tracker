package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        String answer = "Может быть";
        int randomInt = new Random().nextInt(3);
        if (randomInt == 0) {
            answer = "Да";
        } else if (randomInt == 1) {
            answer = "Нет";
        }
        System.out.println(answer);
    }
}
