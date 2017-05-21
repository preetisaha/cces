package com.uwrf.cloudcomputing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.uwrf.cloudcomputing.dto.SurveyResultData;

@Service
public class AnalyticsService {

	@Autowired
	private AmazonDynamoDBClient dynamoDB;

	private String tableName = "survey_data";

	public List<SurveyResultData> getSurveyOneResults() {
		HashMap<String, Condition> scanFilter = new HashMap<String, Condition>();
		Condition condition = new Condition().withComparisonOperator(ComparisonOperator.EQ.toString())
				.withAttributeValueList(new AttributeValue().withN("1"));
		scanFilter.put("american", condition);
		ScanRequest scanRequest = new ScanRequest(tableName).withScanFilter(scanFilter);
		ScanResult scanResult = dynamoDB.scan(scanRequest);
		return getSurveyResultsData(getSurveyResults(scanResult));
	}

	public List<SurveyResultData> getSurveyTwoResults() {
		HashMap<String, Condition> scanFilter = new HashMap<String, Condition>();
		Condition condition = new Condition().withComparisonOperator(ComparisonOperator.EQ.toString())
				.withAttributeValueList(new AttributeValue().withN("1"));
		scanFilter.put("european", condition);
		ScanRequest scanRequest = new ScanRequest(tableName).withScanFilter(scanFilter);
		ScanResult scanResult = dynamoDB.scan(scanRequest);
		return getSurveyResultsData(getSurveyResults(scanResult));
	}
	
	private List<SurveyResultData> getSurveyResultsData(HashMap<Integer, Map<String, Integer>> mapedResults) {
		List<SurveyResultData> resultList = new ArrayList<>();
		for(int eachAge : mapedResults.keySet()) {
			Map<String, Integer> favVehicleMap = mapedResults.get(eachAge);
			resultList.add(new SurveyResultData(eachAge, 
					favVehicleMap.containsKey("honda")?favVehicleMap.get("honda"):0,
					favVehicleMap.containsKey("mercedes")?favVehicleMap.get("mercedes"):0,
					favVehicleMap.containsKey("ferrari")?favVehicleMap.get("ferrari"):0));
		}
		return resultList;
	}
	
	private HashMap<Integer, Map<String, Integer>> getSurveyResults(ScanResult scanResult) {
		Iterator<Map<String, AttributeValue>> ite = scanResult.getItems().iterator();
		HashMap<Integer, Map<String, Integer>> results = new HashMap<>();
		while (ite.hasNext()) {
			Map<String, AttributeValue> rawResult = ite.next();
			int age = (Integer.parseInt(rawResult.get("age").getN())/10)*10;
			int favCar = Integer.parseInt(rawResult.get("favCar").getN());
			
			if (!results.containsKey(age)) {
				results.put(age, new HashMap<String, Integer>());
			}
				
			Map<String, Integer> respBlob = results.get(age);
			
			switch(favCar) {
				case 1: {
					if (respBlob.containsKey("honda")) {
						respBlob.put("honda", respBlob.get("honda") + 1);
					} else {
						respBlob.put("honda", 1);
					}
					break;
				}
				case 2: {
					if (respBlob.containsKey("mercedes")) {
						respBlob.put("mercedes", respBlob.get("mercedes") + 1);
					} else {
						respBlob.put("mercedes", 1);
					}
					break;
				}
				case 3: {
					if (respBlob.containsKey("ferrari")) {
						respBlob.put("ferrari", respBlob.get("ferrari") + 1);
					} else {
						respBlob.put("ferrari", 1);
					}
					break;
				}
			}
			
		}
		return results; 	
	}
}
