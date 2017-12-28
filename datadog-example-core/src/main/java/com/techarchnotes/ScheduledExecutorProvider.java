package com.techarchnotes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorProvider {
    private static final long INITIAL_DELAY_SECONDS = 1;
    private static final long SUBSEQUENT_DELAY_SECONDS = 60;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void scheduleWithDefaultDelays(Runnable task) {
        executorService.scheduleWithFixedDelay(
            task,
            INITIAL_DELAY_SECONDS,
            SUBSEQUENT_DELAY_SECONDS,
            TimeUnit.SECONDS);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
