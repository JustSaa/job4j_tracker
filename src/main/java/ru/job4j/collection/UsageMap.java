package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("ivan@gmail.com", "Ivanov");
        map.put("petr@gmail.com", "Petrovich");
        for (String email : map.keySet()) {
            System.out.println(email + " - " + map.get(email));
        }
    }
}
