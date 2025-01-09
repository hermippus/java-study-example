package me.hermippus.command.manager;

import me.hermippus.economy.manager.EconomyManager;

public interface EconomyCommand {
    void execute(EconomyManager economyManager);
}
