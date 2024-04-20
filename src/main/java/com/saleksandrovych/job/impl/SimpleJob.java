package com.saleksandrovych.job.impl;

import com.saleksandrovych.job.FlinkJob;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.stereotype.Component;

@Component
public class SimpleJob extends FlinkJob {
    @Override
    public void registerJob(StreamExecutionEnvironment environment) {
        environment.fromElements("value_1", "value_2", "value_3")
                .map(value -> "after_map_" + value)
                .print();
    }
}
