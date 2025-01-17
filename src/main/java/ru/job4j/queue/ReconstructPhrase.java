package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder evenChars = new StringBuilder();
        int sizeQueue = evenElements.size();
        for (int i = 0; i < sizeQueue; i++) {
            if (i % 2 == 0) {
                evenChars.append(evenElements.poll());
                continue;
            }
            evenElements.poll();
        }
        return evenChars.toString();
    }

    private String getDescendingElements() {
        StringBuilder descChars = new StringBuilder();
        int sizeQueue = descendingElements.size();
        for (int i = 0; i < sizeQueue; i++) {
            descChars.append(descendingElements.pollLast());
        }
        return descChars.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}