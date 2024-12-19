package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item result = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] allItems = new Item[size];
        for (int i = 0; i < size; i++) {
            allItems[i] = items[i];
        }
        return allItems;
    }

    public Item[] findByName(String key) {
        Item[] allItems = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                allItems[i] = items[i];
                counter++;
            }
        }
        return Arrays.copyOf(allItems, counter);
    }
}