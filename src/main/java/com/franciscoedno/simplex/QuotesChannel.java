package com.franciscoedno.simplex;

import java.util.Queue;

public class QuotesChannel {
    private final Queue<String> messages;

    public QuotesChannel(Queue<String> messages) {
        this.messages = messages;
    }

    public void put(String quote) {
        System.out.printf("Inserindo item. Tamanho atual: %d\n", size());
        messages.add(quote);
    }

    public String get() {
        System.out.printf("Removendo item. Tamanho atual: %d\n", size());
        return messages.poll();
    }

    public int size() {
        return messages.size();
    }
}
