package me.hermippus.economy.manager;

import me.hermippus.economy.storage.DataStorage;

public class EconomyManagerSingleton {

    private static DataStorage storage;
    private static EconomyManager instance;

    public static synchronized EconomyManager getInstance() {
        if (instance == null) {
            if (storage == null) {
                throw new IllegalStateException("DataStorage must be initialized first");
            }
            instance = new EconomyManagerImpl(storage);
        }
        return instance;
    }

    public static void initializeStorage(DataStorage newStorage) {
        storage = newStorage;
        instance = null;
    }

}
