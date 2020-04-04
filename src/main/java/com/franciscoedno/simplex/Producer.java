package com.franciscoedno.simplex;

public class Producer implements Runnable {
    private final QuotesChannel channel;
    private final QuoteBase quoteBase;

    public Producer(QuotesChannel channel, QuoteBase quoteBase) {
        this.channel = channel;
        this.quoteBase = quoteBase;
    }

    @Override
    public void run() {
        fillChannel();
        while (true) {
            if (channel.size() >= 50) {
                continue;
            }
            fillChannel();
        }
    }

    private void fillChannel() {
        while(channel.size() < 100) {
            channel.put(quoteBase.peekRandom());
        }
    }
}
