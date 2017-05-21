package com.uwrf.cloudcomputing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uwrf.cloudcomputing.dto.SurveyData;
import com.uwrf.cloudcomputing.service.SurveyService;

@RestController
@RequestMapping(value="/survey")
public class SurveyController {
	
	@Autowired
	private SurveyService service;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void surveyService(@RequestBody @Valid final SurveyData data) {
		service.save(data);
	}
	
	/*private String testMethod() throws Exception{
		String msg;
		try {
            String tableName = "my-favorite-movies-table";

            // Create a table with a primary hash key named 'name', which holds a string
            CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(tableName)
                .withKeySchema(new KeySchemaElement().withAttributeName("name").withKeyType(KeyType.HASH))
                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("name").withAttributeType(ScalarAttributeType.S))
                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));

            // Create table if it does not exist yet
            TableUtils.createTableIfNotExists(dynamoDB, createTableRequest);
            // wait for the table to move into ACTIVE state
            TableUtils.waitUntilActive(dynamoDB, tableName);

            // Describe our new table
            DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName(tableName);
            TableDescription tableDescription = dynamoDB.describeTable(describeTableRequest).getTable();
            System.out.println("Table Description: " + tableDescription);

            // Add an item
            Map<String, AttributeValue> item = newItem("Bill & Ted's Excellent Adventure", 1989, "****", "James", "Sara");
            PutItemRequest putItemRequest = new PutItemRequest(tableName, item);
            PutItemResult putItemResult = dynamoDB.putItem(putItemRequest);
            System.out.println("Result: " + putItemResult);

            // Add another item
            item = newItem("Airplane", 1980, "*****", "James", "Billy Bob");
            putItemRequest = new PutItemRequest(tableName, item);
            putItemResult = dynamoDB.putItem(putItemRequest);
            System.out.println("Result: " + putItemResult);

            // Scan items for movies with a year attribute greater than 1985
            HashMap<String, Condition> scanFilter = new HashMap<String, Condition>();
            Condition condition = new Condition()
                .withComparisonOperator(ComparisonOperator.GT.toString())
                .withAttributeValueList(new AttributeValue().withN("1985"));
            scanFilter.put("year", condition);
            ScanRequest scanRequest = new ScanRequest(tableName).withScanFilter(scanFilter);
            ScanResult scanResult = dynamoDB.scan(scanRequest);
            msg = scanResult.toString();

        } catch (AmazonServiceException ase) {
            msg = "Caught an AmazonServiceException, which means your request made it "
                    + "to AWS, but was rejected with an error response for some reason.\n";
            msg = msg + "Error Message:    " + ase.getMessage() + "\n";
            msg = msg + "HTTP Status Code: " + ase.getStatusCode() + "\n";
            msg = msg + "AWS Error Code:   " + ase.getErrorCode() + "\n";
            msg = msg + "Error Type:       " + ase.getErrorType() + "\n";
            msg = msg + "Request ID:       " + ase.getRequestId() + "\n";
        } catch (AmazonClientException ace) {
        	msg = "Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with AWS, "
                    + "such as not being able to access the network.";
        	msg = msg + "Error Message: " + ace.getMessage() + "\n";
        }
		return msg;
	}
	
	private static Map<String, AttributeValue> newItem(String name, int year, String rating, String... fans) {
        Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
        item.put("name", new AttributeValue(name));
        item.put("year", new AttributeValue().withN(Integer.toString(year)));
        item.put("rating", new AttributeValue(rating));
        item.put("fans", new AttributeValue().withSS(fans));

        return item;
    }*/
}
