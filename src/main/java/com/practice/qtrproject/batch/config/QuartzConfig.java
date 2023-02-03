package com.practice.qtrproject.batch.config;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class QuartzConfig extends QuartzJobBean {

    private final JobLocator jobLocator;
    private final JobLauncher jobLauncher;

    public QuartzConfig(JobLocator jobLocator, JobLauncher jobLauncher) {
        this.jobLocator = jobLocator;
        this.jobLauncher = jobLauncher;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Job job = jobLocator.getJob("deleteJob");
            JobParameters params = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();
            //jobLauncher.run(job, params);
            // if there is no jobparamter
             jobLauncher.run(job, new JobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
