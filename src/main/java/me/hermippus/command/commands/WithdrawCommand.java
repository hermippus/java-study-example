package me.hermippus.command.commands;

import me.hermippus.command.manager.EconomyCommand;
import me.hermippus.economy.CurrencyType;
import me.hermippus.economy.manager.EconomyManager;

import java.util.Scanner;

public class WithdrawCommand implements EconomyCommand {

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
}
