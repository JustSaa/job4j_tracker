package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left == right) {
            return 0;
        }
        int lengthLeft = left.length();
        int lengthRight = right.length();
        int minLength = Math.min(lengthLeft, lengthRight);
        for (int i = 0; i < minLength; i++) {
            char c1 = left.charAt(i);
            char c2 = right.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return lengthLeft - lengthRight;
    }
}