package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found");
    }

    public static void main(String[] args) {
        String[] names = new String[]{"One", "Two", "Three"};
        String key = "Four";
        try {
            indexOf(names, key);
        } catch (ElementNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}