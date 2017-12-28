package com.techarchnotes.metric;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DatadogFakeMetricsReporter implements MetricsReporter {

    private final MetricsProvider metricsProvider;
    private final MetricsBroker metricsBroker;

    @Override
    public void report() {
        metricsBroker.send(metricsProvider.getGauges());
    }
}
