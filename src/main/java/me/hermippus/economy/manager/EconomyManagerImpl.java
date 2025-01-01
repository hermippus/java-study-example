package me.hermippus.economy.manager;

import lombok.NonNull;
import me.hermippus.economy.CurrencyType;
import me.hermippus.economy.storage.DataStorage;

public class EconomyManagerImpl implements EconomyManager {

    private final DataStorage storage;

    public EconomyManagerImpl(DataStorage storage) {
        this.storage = storage;
    }

    @Override
    public void addBalance(@NonNull String player, @NonNull CurrencyType type, int amount) {
        storage.add(player, type, amount);
    }

    @Override
    public void withdrawBalance(@NonNull String player, @NonNull CurrencyType type, int amount) {
        storage.remove(player, type, amount);
    }

    @Override
    public int getBalance(@NonNull String player, @NonNull CurrencyType type) {
        return storage.load(player, type);
    }
}
