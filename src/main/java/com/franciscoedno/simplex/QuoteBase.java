package com.franciscoedno.simplex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteBase {
    public String peekRandom() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    App.class.getResourceAsStream("/quotes.txt")));

            List<String> quotes = new ArrayList<>();

            StringBuilder quote = new StringBuilder();
            String quoteLine;
            while((quoteLine = reader.readLine()) != null) {
                if (quoteLine.isBlank()) {
                    quotes.add(quote.toString());
                    quote = new StringBuilder();
                    continue;
                }
                quote.append(quoteLine);
                quote.append("\n");
            }

            return quotes.get(new Random().nextInt(quotes.size()));
        } catch (Exception e) {
            return "A vingança nunca é plena, mata a alma e envenena.\n-- Seu Madruga";
        }
    }
}
