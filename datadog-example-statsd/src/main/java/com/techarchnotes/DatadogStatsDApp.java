package com.techarchnotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techarchnotes.metric.DatadogFakeMetricsReporter;
import com.techarchnotes.metric.FakeMetricsProvider;
import com.techarchnotes.metric.MetricsBroker;
import com.techarchnotes.metric.StatsDMetricsBroker;
import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;
import com.timgroup.statsd.StatsDClientErrorHandler;

public class DatadogStatsDApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatadogStatsDApp.class);
    private static final StatsDClientErrorHandler ERROR_HANDLER = exception -> LOGGER.error(exception.getMessage(), exception);
    private static final String PREFIX = "datadog.example.statsd";
    private static final String BIND_HOSTNAME = "localhost";
    private static final int PORT = 8125;
    private static final String[] CONSTANT_TAGS = {};

    public static void main(String[] args) {

        DatadogFakeMetricsReporter fakeMetricsReporter = new DatadogFakeMetricsReporter(
            new FakeMetricsProvider(),
            createStatsDBroker());

        startReporting(fakeMetricsReporter);
    }

    private static MetricsBroker createStatsDBroker() {
        StatsDClient statsDClient = new NonBlockingStatsDClient(
            PREFIX,
            BIND_HOSTNAME,
            PORT,
            CONSTANT_TAGS,
            ERROR_HANDLER);

        return new StatsDMetricsBroker(statsDClient);
    }

    private static void startReporting(DatadogFakeMetricsReporter fakeMetricsReporter) {
        ScheduledExecutorProvider executorProvider = new ScheduledExecutorProvider();
        executorProvider.scheduleWithDefaultDelays(() -> fakeMetricsReporter.report());
    }
}