package com.techarchnotes.metric;

import io.dropwizard.lifecycle.Managed;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techarchnotes.ScheduledExecutorProvider;

@RequiredArgsConstructor
public class DatadogFakeMetricsReporterManager implements Managed {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatadogFakeMetricsReporterManager.class);

    private final MetricsReporter metricsReporter;
    private final ScheduledExecutorProvider executorProvider;

    @Override
    public void start() throws Exception {
        LOGGER.info("Starting service ...");
        executorProvider.scheduleWithDefaultDelays(() -> metricsReporter.report());
    }

    @Override
    public void stop() throws Exception {
        LOGGER.info("Stopping service ...");

        executorProvider.shutdown();
    }
}
