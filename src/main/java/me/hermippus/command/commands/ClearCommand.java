package me.hermippus.command.commands;

import me.hermippus.command.manager.Command;

public class ClearCommand implements Command {

    @Override
    public void execute() {
        for (int i = 0; i < 256; i++) {
            System.out.println(" ");
        }
    }
}
