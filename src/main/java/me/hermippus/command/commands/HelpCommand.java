package me.hermippus.command.commands;

import me.hermippus.command.manager.Command;

public class HelpCommand implements Command {


    @Override
    public void execute() {
        System.out.println(
                """
                        Available commands:
                        - help — show this message
                        - economy add — add balance to a player
                        - economy withdraw — withdraw balance from a player
                        - economy get — check a player's balance
                        - clear — clear the console
                        - exit — exit the program
                        """
        );
    }
}
