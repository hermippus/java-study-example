package me.hermippus.economy.manager;

import lombok.NonNull;
import me.hermippus.economy.CurrencyType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EconomyManagerImpl implements EconomyManager {

    private final Map<String, ConcurrentHashMap<CurrencyType, Integer>> players = new ConcurrentHashMap<>();

    @Override
    public void addBalance(@NonNull String player, @NonNull CurrencyType type, int amount)  {
        players.computeIfAbsent(player, k -> new ConcurrentHashMap<>())
                .merge(type, amount, Integer::sum);
    }

    @Override
    public void takeBalance(@NonNull String player, @NonNull CurrencyType type, int amount)  {
        players.computeIfPresent(player, (k, balances) -> {
            balances.computeIfPresent(type, (c, balance) -> balance >= amount ? balance - amount : balance);
            return balances.isEmpty() ? null : balances;
        });
    }

    @Override
    public int getBalance(@NonNull String player, @NonNull CurrencyType type)  {
        return players.getOrDefault(player, new ConcurrentHashMap<>())
                .getOrDefault(type, 0);
    }
}
