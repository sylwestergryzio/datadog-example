package com.techarchnotes.metric;

import java.util.List;

public interface MetricsBroker {
    void send(List<CustomGauge> gauges);
}
