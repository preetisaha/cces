package com.uwrf.cloudcomputing.dto;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class SurveyData {

	@NotNull
	private String email;
	
	@NotNull
	private int age;
	
	@NotNull
	private int american;
	
	@NotNull
	private int european;
	
	@NotNull
	private int favCar;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFavCar() {
		return favCar;
	}

	public void setFavCar(int favCar) {
		this.favCar = favCar;
	}
	
	public int getAmerican() {
		return american;
	}

	public void setAmerican(int american) {
		this.american = american;
	}

	public int getEuropean() {
		return european;
	}

	public void setEuropean(int european) {
		this.european = european;
	}

	public Map<String, AttributeValue> getDynamoDBItem() {
		Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
        item.put("email", new AttributeValue(email));
        item.put("age", new AttributeValue().withN(Integer.toString(age)));
        item.put("american", new AttributeValue().withN(Integer.toString(american)));
        item.put("european", new AttributeValue().withN(Integer.toString(european)));
        item.put("favCar", new AttributeValue().withN(Integer.toString(favCar)));
        
        return item;
	}

	@Override
	public String toString() {
		return "email - " + email + ", age - " + age + ", american - " + american
				+ ", european - " + european + ", favCar - " + favCar;
	}
}
