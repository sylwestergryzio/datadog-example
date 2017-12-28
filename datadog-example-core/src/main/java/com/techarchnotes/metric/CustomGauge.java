package com.techarchnotes.metric;

import lombok.Data;

@Data
public class CustomGauge {
    private final String name;
    private final Number value;
}
