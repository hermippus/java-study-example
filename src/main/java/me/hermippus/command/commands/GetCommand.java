package me.hermippus.command.commands;

import me.hermippus.command.manager.EconomyCommand;
import me.hermippus.economy.CurrencyType;
import me.hermippus.economy.manager.EconomyManager;

import java.util.Scanner;

public class GetCommand implements EconomyCommand {


    @Override
    public void execute(EconomyManager economyManager) {
        System.out.print("Enter the player name: ");
        Scanner scanner = new Scanner(System.in);
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
