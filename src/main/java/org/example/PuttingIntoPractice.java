package org.example;

import java.util.Arrays;
import java.util.List;

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

        System.out.println("All transactions:");
        System.out.println(transactions);

        printLine();
        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).");
        List<Transaction> exercise1 = TransactionsUtils.findAllTransactionsForTheYear(transactions, 2011);
        System.out.println(exercise1);

        printLine();
        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        List<String> exercise2 = TransactionsUtils.findUniqueCities(transactions);
        System.out.println(exercise2);

        printLine();
        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        List<Trader> exercise3 = TransactionsUtils.allTradersFromCity(transactions, "Cambridge");
        System.out.println(exercise3);

        printLine();
        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        String exercise4 = TransactionsUtils.allTradersNames(transactions);
        System.out.println(exercise4);

        printLine();
        System.out.println("5. Выяснить, существует ли хоть один трейдер из Милана.");
        boolean exercise5 = TransactionsUtils.existTraderFromCity(transactions, "Milan");
        System.out.println(exercise5);

        printLine();
        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        List<Integer> exercise6 = TransactionsUtils.allTransactionsValuesFromCity(transactions, "Cambridge");
        System.out.println(exercise6);

        printLine();
        System.out.println("7. Какова максимальная сумма среди всех транзакций?");
        int exercise7 = TransactionsUtils.maxTransactionValue(transactions);
        System.out.println(exercise7);

        printLine();
        System.out.println("8. Найти транзакцию с минимальной суммой.");
        Transaction exercise8 = TransactionsUtils.getTransactionWithMinValue(transactions);
        System.out.println(exercise8);

    }

    private static void printLine() {
        System.out.println("========================================================");
    }
}
