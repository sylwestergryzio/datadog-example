package com.techarchnotes.metric;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.coursera.metrics.datadog.DatadogReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Gauge;

@RequiredArgsConstructor
public class DatadogMetricsBroker implements MetricsBroker {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatadogMetricsBroker.class);

    private final DatadogReporter datadogReporter;

    @Override
    public void send(List<CustomGauge> gauges) {
        report(listToSortedMap(gauges));
    }

    private SortedMap<String, Gauge> listToSortedMap(List<CustomGauge> gauges) {
        Map<String, Gauge<Number>> gaugesMap = gauges.stream()
            .collect(Collectors.toMap(g -> g.getName(), g -> (Gauge<Number>) () -> g.getValue()));
        return new TreeMap<>(gaugesMap);
    }

    private void report(SortedMap<String, Gauge> gaugesMap) {
        LOGGER.info("Sending {} gauges", gaugesMap.size());

        datadogReporter.report(
            gaugesMap,
            Collections.emptySortedMap(),
            Collections.emptySortedMap(),
            Collections.emptySortedMap(),
            Collections.emptySortedMap());
    }
}