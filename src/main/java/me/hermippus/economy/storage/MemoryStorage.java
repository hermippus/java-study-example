package me.hermippus.economy.storage;

import me.hermippus.economy.CurrencyType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStorage implements DataStorage {

    private final Map<String, ConcurrentHashMap<CurrencyType, Integer>> storage = new ConcurrentHashMap<>();

    @Override
    public void add(String player, CurrencyType type, int amount) {
        storage.computeIfAbsent(player, k -> new ConcurrentHashMap<>())
                .merge(type, amount, Integer::sum);
    }

    @Override
    public void remove(String player, CurrencyType type, int amount) {
        storage.computeIfPresent(player, (k, balances) -> {
            balances.computeIfPresent(type, (c, balance) -> balance >= amount ? balance - amount : balance);
            return balances.isEmpty() ? null : balances;
        });
    }

    @Override
    public int load(String player, CurrencyType type) {
        return storage.getOrDefault(player, new ConcurrentHashMap<>())
                .getOrDefault(type, 0);
    }
}
