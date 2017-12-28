package com.techarchnotes;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import org.coursera.metrics.datadog.DatadogReporter;
import org.coursera.metrics.datadog.transport.HttpTransport;

import com.codahale.metrics.MetricRegistry;
import com.techarchnotes.configuration.DatadogExampleConfiguration;
import com.techarchnotes.metric.DatadogFakeMetricsReporter;
import com.techarchnotes.metric.DatadogFakeMetricsReporterManager;
import com.techarchnotes.metric.DatadogMetricsBroker;
import com.techarchnotes.metric.FakeMetricsProvider;
import com.techarchnotes.metric.MetricsBroker;
import com.techarchnotes.metric.MetricsReporter;

public class DatadogExampleApp extends Application<DatadogExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new DatadogExampleApp().run(args);
    }

    @Override
    public void run(DatadogExampleConfiguration configuration, Environment environment) throws Exception {
        DatadogReporter datadogReporter = DatadogReporter.forRegistry(new MetricRegistry())
            .withTransport(new HttpTransport.Builder().withApiKey(configuration.getApiKey()).build())
            .withPrefix("datadog.example")
            .withHost("techarchnotes.com")
            .build();

        MetricsBroker datadogMetricsBroker = new DatadogMetricsBroker(datadogReporter);
        MetricsReporter metricsReporter = new DatadogFakeMetricsReporter(new FakeMetricsProvider(), datadogMetricsBroker);

        environment.lifecycle().manage(
            new DatadogFakeMetricsReporterManager(
                metricsReporter,
                new ScheduledExecutorProvider()));
    }
}
