package com.techarchnotes.metric;

import java.util.List;

import com.timgroup.statsd.StatsDClient;

public class StatsDMetricsBroker implements MetricsBroker {
    private final StatsDClient statsDClient;

    public StatsDMetricsBroker(StatsDClient statsDClient) {
        this.statsDClient = statsDClient;
    }

    @Override
    public void send(List<CustomGauge> gauges) {
        gauges.forEach(g -> statsDClient.recordGaugeValue(g.getName(), g.getValue().longValue()));
    }
}
