package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] arg) {
        Student studentOne = new Student();
        studentOne.setFullName("Ivanov Ivan");
        studentOne.setDateOfAdmission(new Date(2025, 11, 22));
        studentOne.setGroup(1234);
        System.out.println(studentOne.getFullName());
        System.out.println(studentOne.getGroup());
        System.out.println(studentOne.getDateOfAdmission());
    }
}
