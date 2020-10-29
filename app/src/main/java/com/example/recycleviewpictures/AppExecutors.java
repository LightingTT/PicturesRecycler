/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {
    private static AppExecutors instance;

    public static AppExecutors getInstance()
    {
        if (instance == null)
        {
            instance = new AppExecutors();
        }
        return instance;
    }
    private final ScheduledExecutorService networkIO = Executors.newScheduledThreadPool(2);

    public ScheduledExecutorService getNetworkIO(){
        return networkIO;
    }


}
