package com.uwrf.cloudcomputing.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.amazonaws.services.dynamodbv2.util.TableUtils.TableNeverTransitionedToStateException;
import com.uwrf.cloudcomputing.dto.SurveyData;

@Service
public class SurveyService {
	
	@Autowired
    private AmazonDynamoDBClient dynamoDB;
	
	private String tableName = "survey_data";
	
	public void save(SurveyData data) {
		PutItemRequest putItemRequest = new PutItemRequest(tableName, data.getDynamoDBItem());
        dynamoDB.putItem(putItemRequest);
	}
	
	@PostConstruct
	public void init() {
		// Create a table with a primary hash key named 'name', which holds a string
		System.out.println("Creating table if not Exist");
        CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(tableName)
            .withKeySchema(new KeySchemaElement().withAttributeName("email").withKeyType(KeyType.HASH))
            .withAttributeDefinitions(new AttributeDefinition().withAttributeName("email").withAttributeType(ScalarAttributeType.S))
            .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));

        // Create table if it does not exist yet
        TableUtils.createTableIfNotExists(dynamoDB, createTableRequest);
        // wait for the table to move into ACTIVE state
        try {
			TableUtils.waitUntilActive(dynamoDB, tableName);
		} catch (TableNeverTransitionedToStateException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Describe our new table
        DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName(tableName);
        TableDescription tableDescription = dynamoDB.describeTable(describeTableRequest).getTable();
        System.out.println("Table Description: " + tableDescription);
	}
}
