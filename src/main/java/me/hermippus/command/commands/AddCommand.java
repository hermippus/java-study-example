package me.hermippus.command.commands;

import me.hermippus.command.manager.EconomyCommand;
import me.hermippus.economy.CurrencyType;
import me.hermippus.economy.manager.EconomyManager;

import java.util.Scanner;

public class AddCommand implements EconomyCommand {

    @Override
    public void execute(EconomyManager economyManager) {
        System.out.print("Enter the player name: ");
        Scanner scanner = new Scanner(System.in);
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
}
