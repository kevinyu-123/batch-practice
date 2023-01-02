package com.practice.qtrproject.batch.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class CustomBatchConfigurer extends DefaultBatchConfigurer {

    @Autowired
    private DataSource dataSource;
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
