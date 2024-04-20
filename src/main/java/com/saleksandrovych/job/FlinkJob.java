package com.saleksandrovych.job;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public abstract class FlinkJob {
    public abstract void registerJob(StreamExecutionEnvironment environment);
}
