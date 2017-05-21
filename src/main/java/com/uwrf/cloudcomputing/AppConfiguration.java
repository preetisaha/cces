package com.uwrf.cloudcomputing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
public class AppConfiguration {

	@Bean
	@Scope("prototype")
	public AmazonDynamoDBClient getAmazonDynamoDBClient() {
		AmazonDynamoDBClient dynamoDB = new AmazonDynamoDBClient(new AWSCredentials() {
			
			@Override
			public String getAWSSecretKey() {
				return "jzpPnaBISBmlUm7vzBkeY9Kc+k/bzRcYxC6trEKB";
			}
			
			@Override
			public String getAWSAccessKeyId() {
				return "AKIAI7PTKSVS2UG4EWCA";
			}
		});
        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        dynamoDB.setRegion(usWest2);
        
        return dynamoDB;
	}
}
