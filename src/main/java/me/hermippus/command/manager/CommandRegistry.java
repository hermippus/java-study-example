package me.hermippus.command.manager;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private final Map<String, Command> commands = new HashMap<>();
    private final Map<String, EconomyCommand> economyCommands = new HashMap<>();

    public void register(String name, Command command) {
        commands.put(name, command);
    }

    public void register(String name, EconomyCommand economyCommand) {
        economyCommands.put(name, economyCommand);
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }

    public EconomyCommand getEconomyCommand(String name) {
        return economyCommands.get(name);
    }
}
