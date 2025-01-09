package me.hermippus.command.commands;

import me.hermippus.command.manager.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
