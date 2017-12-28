package com.techarchnotes.metric;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;

public class FakeMetricsProvider implements MetricsProvider {

    @Override
    public List<CustomGauge> getGauges() {

        Random random = new Random();

        return ImmutableList.of(
            new CustomGauge("tableSizeMB", 100 + random.nextInt(50)),
            new CustomGauge("deadTuples", 51 + random.nextInt(20)),
            new CustomGauge("liveTuples", 100 + random.nextInt(20))
        );
    }
}
