package com.practice.qtrproject.batch.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class CustomBatchConfigurer extends DefaultBatchConfigurer {

    @Override
    public void setDataSource(DataSource dataSource) {
        // 여기를 비워놓는다
    }
}
