package ru.job4j.stream;

import ru.job4j.stream.Suit;
import ru.job4j.stream.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        List<Card> dec = Stream.of(Suit.values()).flatMap(
                        suit1 -> Stream.of(Value.values()).map(value1 -> new Card(suit1, value1)))
                .toList();
    }
}