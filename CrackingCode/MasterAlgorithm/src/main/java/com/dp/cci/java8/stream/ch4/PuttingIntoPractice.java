package com.dp.cci.java8.stream.ch4;

import com.dp.cci.java8.domain.Trader;
import com.dp.cci.java8.domain.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> tranYear2011 = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .filter(transaction -> transaction.getYear() == 2011)
                .collect(Collectors.toList());

        // Query 2: What are all the unique cities where the traders work?
        List<String> distinctCity = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        Set<String> distinctSet = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .map(Trader::getCity)
                .collect(Collectors.toSet());

        // Query 3: Find all traders from Cambridge and sort them by name.
        List<Trader> cambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        String cambridge1 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .sorted()
                .reduce("", (a, b) -> a + b);

        // Query 4: Return a string of all traders’ names sorted alphabetically.
        List<String> sortedName = transactions.stream().map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.toList());

        transactions.stream().map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining());

        // Query 5: Are there any trader based in Milan?
        boolean milan = transactions.stream().map(Transaction::getTrader)
                .anyMatch(trader -> trader.getName().equals("Milan"));


        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        List<Transaction> updateTransaction = transactions.stream().map(transaction -> {
            if (transaction.getTrader().getCity().equals("Milan")) {
                transaction.getTrader().setCity("Cambridge");
            }
            return transaction;
        })
                .collect(Collectors.toList());

        // Query 7: What's the highest value in all the transactions?
        Optional<Transaction> max = transactions.stream().max(Comparator.comparing(Transaction::getValue));
        Optional<Transaction> max1 = transactions.stream().max(Comparator.comparing(Transaction::getValue));

    }


}
