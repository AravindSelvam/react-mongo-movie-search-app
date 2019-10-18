package com.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;


@Configuration
public class ApplicationContextConfig {
	
	@Bean
	public MongoClient mongo() {
		return new MongoClient("localhost",27017);
	}
	
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongo(), "test");
	}

}
