package com.techarchnotes.configuration;

import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatadogExampleConfiguration extends Configuration {
    @JsonProperty
    @Getter @Setter
    private String apiKey;
}
