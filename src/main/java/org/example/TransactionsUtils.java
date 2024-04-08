package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsUtils {

    //  1. Найти все транзакции за 2011 год и отсортировать
    //  их по сумме (от меньшей к большей).
    public static List<Transaction> findAllTransactionsForTheYear(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(t -> t.getYear() == year)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
    }

    //  2. Вывести список неповторяющихся городов, в которых работают трейдеры.
    public static List<String> findUniqueCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    //  3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
    public static List<Trader> allTradersFromCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals(city))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    //  4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
    public static String allTradersNames(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining("; "));
    }

    //  5. Выяснить, существует ли хоть один трейдер из Милана.
    public static boolean existTraderFromCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals(city));
    }

    //  6. Вывести суммы всех транзакций трейдеров из Кембриджа.
    public static List<Integer> allTransactionsValuesFromCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    //  7. Какова максимальная сумма среди всех транзакций?
    public static int maxTransactionValue(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo)
                .orElse(-1);
    }

    //  8. Найти транзакцию с минимальной суммой.
    public static Transaction getTransactionWithMinValue(List<Transaction> transactions) {
        return transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .orElse(null);
    }
}
