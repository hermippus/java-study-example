package me.hermippus.economy.storage;

import me.hermippus.economy.CurrencyType;

public interface DataStorage {
    void add(String player, CurrencyType type, int amount);

    void remove(String player, CurrencyType type, int amount);

    int load(String player, CurrencyType type);
}
