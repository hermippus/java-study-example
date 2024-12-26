package me.hermippus.economy.manager;

import lombok.Getter;

public class EconomyManagerSingleton {

    @Getter
    private static final EconomyManager instance = new EconomyManagerImpl();
}
