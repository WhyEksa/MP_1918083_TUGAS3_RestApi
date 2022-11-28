package com.wes.mp_1918083_tugas3_restapi.restapi.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutor {
    private static AppExecutor instance;
    public static AppExecutor getInstance() {
        if (instance == null) {
            instance = new AppExecutor();
        }
        return instance;
    }

    private final ScheduledExecutorService networkIO = Executors.newScheduledThreadPool(3);
    public ScheduledExecutorService getNetworkIO() {
        return networkIO;
    }
}
