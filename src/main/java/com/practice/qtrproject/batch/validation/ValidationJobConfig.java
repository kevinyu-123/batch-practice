package com.practice.qtrproject.batch.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * desc : 파일 이름 파라미터 전달 및 검증
 * run : name = validParamJob / fileName = test.csv
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class ValidationJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job validParamJob(Step validParamStep){
        return jobBuilderFactory.get("validParamJob")
                .incrementer(new RunIdIncrementer())
                .validator(new ParamValidator())
        //        .validator(multipleValidator())
                .start(validParamStep)
                .build();
    }

    // 여러 validator 등록 가능
    private CompositeJobParametersValidator multipleValidator(){
        CompositeJobParametersValidator validator = new CompositeJobParametersValidator();
        validator.setValidators(Arrays.asList(new ParamValidator()));
        return validator;
    }

    @Bean
    @JobScope
    public Step validParamStep(Tasklet validParamTasklet){
        return stepBuilderFactory.get("validParamStep")
                .tasklet(validParamTasklet)
                .build();
    }

    @StepScope
    @Bean
    public Tasklet validParamTasklet(@Value("#{jobParameters['fileName']}") String fileName){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                log.info("fileName : {}",fileName);
                log.info("this is valid param log");
                return RepeatStatus.FINISHED;
            }
        };
    }


}
