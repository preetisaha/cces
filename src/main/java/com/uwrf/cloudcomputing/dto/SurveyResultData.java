package com.uwrf.cloudcomputing.dto;

import javax.validation.constraints.NotNull;

public class SurveyResultData {

	public SurveyResultData() {}
	
	public SurveyResultData(int age, int honda, int mercedes, int ferrari) {
		this.age = age;
		this.honda = honda;
		this.mercedes = mercedes;
		this.ferrari = ferrari;
	}
	
	@NotNull
	private int age;
	
	@NotNull
	private int honda;
	
	@NotNull
	private int mercedes;
	
	@NotNull
	private int ferrari;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHonda() {
		return honda;
	}

	public void setHonda(int honda) {
		this.honda = honda;
	}

	public int getMercedes() {
		return mercedes;
	}

	public void setMercedes(int mercedes) {
		this.mercedes = mercedes;
	}

	public int getFerrari() {
		return ferrari;
	}

	public void setFerrari(int ferrari) {
		this.ferrari = ferrari;
	}
	
}
