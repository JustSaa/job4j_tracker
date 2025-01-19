package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemSortTest {

    @Test
    void sortingByAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Charlie"));
        items.add(new Item("Alice"));
        items.add(new Item("Bob"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Alice"));
        expected.add(new Item("Bob"));
        expected.add(new Item("Charlie"));

        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void sortingByDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Charlie"));
        items.add(new Item("Alice"));
        items.add(new Item("Bob"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Charlie"));
        expected.add(new Item("Bob"));
        expected.add(new Item("Alice"));

        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}
