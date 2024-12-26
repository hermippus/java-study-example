package me.hermippus.economy.manager;

import lombok.NonNull;
import me.hermippus.economy.CurrencyType;

public interface EconomyManager {
    void addBalance(@NonNull  String player, @NonNull CurrencyType type, int amount);

    void takeBalance(@NonNull String player, @NonNull CurrencyType type, int amount);

    int getBalance(@NonNull String player, @NonNull CurrencyType type);
}
