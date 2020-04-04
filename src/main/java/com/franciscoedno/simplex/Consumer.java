package com.franciscoedno.simplex;

public class Consumer implements Runnable {
    private final QuotesChannel channel;

    public Consumer(QuotesChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        String quote;
        while (true) {
            quote = channel.get();
            sleep();

            if (quote == null) {
                System.out.println("Waiting for quote");
                continue;
            }

            System.out.println(quote);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
    }
}
