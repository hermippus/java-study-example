package me.hermippus;

import me.hermippus.economy.CurrencyType;
import me.hermippus.economy.manager.EconomyManager;
import me.hermippus.economy.manager.EconomyManagerSingleton;
import me.hermippus.economy.storage.DataStorage;
import me.hermippus.economy.storage.MemoryStorage;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DataStorage storage = new MemoryStorage();
        EconomyManagerSingleton.initializeStorage(storage);
        EconomyManager economyManager = EconomyManagerSingleton.getInstance();

        while (true) {
            System.out.print("Enter the command (help): ");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "help":
                    System.out.println(
                            """
                                    Available commands:
                                    - help — show this message
                                    - add — add balance to a player
                                    - withdraw - withdraw balance from a player
                                    - get — check a player's balance
                                    - clear — clear the console
                                    - exit  — exit the program
                                    """
                    );
                    break;
                case "add":
                    handleAddBalance(economyManager);
                    break;
                case "withdraw":
                    handleWithdrawBalance(economyManager);
                    break;
                case "get":
                    handleGetBalance(economyManager);
                    break;
                case "clear":
                    clearConsole();
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid command. Type 'help' for a list of commands");
            }
        }
    }

    private static void handleAddBalance(EconomyManager economyManager) {
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

    private static void handleWithdrawBalance(EconomyManager economyManager) {
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

        System.out.print("Enter amount to withdraw: ");
        int amount;
        try {
            amount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount");
            return;
        }

        economyManager.withdrawBalance(player, currency, amount);
        System.out.printf("Withdrew %d %s from %s's balance\n", amount, currency, player);
    }

    private static void handleGetBalance(EconomyManager economyManager) {
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

    private static void clearConsole() {
        for (int i = 0; i < 256; i++) {
            System.out.println(" ");
        }
    }
}
