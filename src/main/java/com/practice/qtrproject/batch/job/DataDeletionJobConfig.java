package com.practice.qtrproject.batch.job;


import com.practice.qtrproject.batch.jobListener.JobLoggerListener;
import com.practice.qtrproject.service.BatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;


@RequiredArgsConstructor
@Slf4j
@Configuration
public class DataDeletionJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private final BatchService batchService;


    @Bean
    public Job deleteJob(){
        return jobBuilderFactory.get("deleteJob")
                .incrementer(new RunIdIncrementer())
                .listener(new JobLoggerListener())
                .start(dataDelStep())
                .build();
    }


    @Bean
    @JobScope
    public Step dataDelStep(){
        return stepBuilderFactory.get("dataDelStep")
                .tasklet(dataDeletionTasklet())
                .build();
    }


    @Bean
    @StepScope
    public MethodInvokingTaskletAdapter dataDeletionTasklet() {
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();
        log.info("METHOD ADAPTER BEGIN : {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        adapter.setTargetObject(batchService);
        adapter.setTargetMethod("deleteByFlag");

        return adapter;
    }







}
