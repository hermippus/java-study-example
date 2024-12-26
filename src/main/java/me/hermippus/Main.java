package me.hermippus;

import me.hermippus.economy.CurrencyType;
import me.hermippus.economy.manager.EconomyManager;
import me.hermippus.economy.manager.EconomyManagerSingleton;

import java.util.Scanner;

public class Main {

    private static final EconomyManager economyManager = EconomyManagerSingleton.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter the command (help): ");
            String command= scanner.nextLine().toLowerCase();

            switch (command) {
                case "help":
                    System.out.println(
                            """
                             Economy commands:
                             - help — this message
                             - add — add balance to player
                             - get — retrieve player balance
                             - clear —  glassy clean
                             - exit  — close program
                             """
                    );
                    break;
                case "add":
                    handleAddBalance();
                    break;
                case "take":
                    handleTakeBalance();
                    break;
                case "get":
                    handleGetBalance();
                    break;
                case "clear":
                    for (int i = 0; i < 256; i++) {
                        System.out.println(" ");
                    }
                    break;
                case "exit":
                    System.out.println("Bye bye");
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void handleAddBalance() {
        System.out.print("Enter the player name: ");
        String player = scanner.nextLine();

        System.out.print("Enter the currency type (GOLD, SILVER, BRONZE): ");
        String currencyType = scanner.nextLine().toUpperCase();

        CurrencyType currency;
        try {
            currency = CurrencyType.valueOf(currencyType);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid currency type");
            return;
        }

        System.out.print("Enter amount to add: ");
        int amount;
        try {
            amount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount");
            return;
        }

        economyManager.addBalance(player, currency, amount);
        System.out.printf("Added %d %s to %s's balance\n", amount, currency, player);
    }

    private static void handleTakeBalance() {
        System.out.print("Enter the player name: ");
        String player = scanner.nextLine();

        System.out.print("Enter the currency type (GOLD, SILVER, BRONZE): ");
        String currencyType = scanner.nextLine().toUpperCase();
        CurrencyType currency;
        try {
            currency = CurrencyType.valueOf(currencyType);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid currency type");
            return;
        }

        System.out.print("Enter amount to deduct: ");
        int amount;
        try {
            amount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount");
            return;
        }

        economyManager.takeBalance(player, currency, amount);
        System.out.printf("Deducted %d %s from %s's balance\n", amount, currency, player);
    }

    private static void handleGetBalance() {
        System.out.print("Enter the player name: ");
        String player = scanner.nextLine();

        int goldBalance = economyManager.getBalance(player, CurrencyType.GOLD);
        int silverBalance = economyManager.getBalance(player, CurrencyType.SILVER);
        int bronzeBalance = economyManager.getBalance(player, CurrencyType.BRONZE);

        System.out.printf(
                """
                        %s's balance:
                        - GOLD: %d
                        - SILVER: %d
                        - BRONZE: %d
                        """, player, goldBalance, silverBalance, bronzeBalance);
    }
}