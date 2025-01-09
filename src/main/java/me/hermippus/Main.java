package me.hermippus;

import me.hermippus.command.manager.Command;
import me.hermippus.command.manager.CommandRegistry;
import me.hermippus.command.manager.EconomyCommand;
import me.hermippus.command.commands.*;
import me.hermippus.economy.manager.EconomyManager;
import me.hermippus.economy.manager.EconomyManagerSingleton;
import me.hermippus.economy.storage.DataStorage;
import me.hermippus.economy.storage.MemoryStorage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CommandRegistry commandRegistry = new CommandRegistry();
        DataStorage storage = new MemoryStorage();
        EconomyManagerSingleton.initializeStorage(storage);
        EconomyManager economyManager = EconomyManagerSingleton.getInstance();

        commandRegistry.register("help", new HelpCommand());
        commandRegistry.register("economy add", new AddCommand());
        commandRegistry.register("economy withdraw", new WithdrawCommand());
        commandRegistry.register("economy get", new GetCommand());
        commandRegistry.register("clear", new ClearCommand());
        commandRegistry.register("exit", new ExitCommand());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("Available commands: help");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.startsWith("economy")) {
                EconomyCommand economyCommand = commandRegistry.getEconomyCommand(input);

                if (economyCommand != null) {
                    economyCommand.execute(economyManager);
                } else {
                    System.out.println("Unknown economy command: " + input);
                }
            } else {
                Command command = commandRegistry.getCommand(input);

                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Unknown command: " + input);
                }
            }
        }
    }
}