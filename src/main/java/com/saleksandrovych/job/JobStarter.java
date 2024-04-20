package com.saleksandrovych.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.flink.core.execution.JobClient;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobStarter {
    private final StreamExecutionEnvironment environment;
    private final List<FlinkJob> flinkJobs;

    public JobStarter(StreamExecutionEnvironment environment, List<FlinkJob> flinkJobs) {
        this.environment = environment;
        this.flinkJobs = flinkJobs;
    }

    public JobClient startJobs() throws Exception {
        if (flinkJobs.isEmpty()) {
            log.info("No Flink Jobs found for start");
            return null;
        }

        for (FlinkJob flinkJob : flinkJobs) {
            log.info("Register job: {}", flinkJob.getClass().getSimpleName());
            flinkJob.registerJob(environment);
        }

        return environment.executeAsync();
    }
}
