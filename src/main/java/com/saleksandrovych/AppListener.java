package com.saleksandrovych;

import com.saleksandrovych.job.JobStarter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("flink.submit-jobs-on-app-start")
public class AppListener {
    private final JobStarter jobStarter;

    public AppListener(JobStarter jobStarter) {
        this.jobStarter = jobStarter;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void onApplicationStart() throws Exception {
        jobStarter.startJobs();
    }
}
