package com.techarchnotes;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import com.techarchnotes.resource.UserResource;

public class AppWithMetricsApplication extends Application<AppWithMetricsConfiguration> {
    public static void main(String[] args) throws Exception {
        new AppWithMetricsApplication().run(args);
    }

    @Override
    public void run(AppWithMetricsConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new UserResource());
    }
}
