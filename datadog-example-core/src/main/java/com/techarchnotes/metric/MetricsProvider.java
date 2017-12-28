package com.techarchnotes.metric;

import java.util.List;

public interface MetricsProvider {
    List<CustomGauge> getGauges();
}
