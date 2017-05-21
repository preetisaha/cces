package com.uwrf.cloudcomputing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uwrf.cloudcomputing.dto.SurveyResultData;
import com.uwrf.cloudcomputing.service.AnalyticsService;

@RestController
@RequestMapping(value="/analytics")
public class AnalyticsController {
	
	@Autowired
	private AnalyticsService service;
	
	@RequestMapping(value = "/survey1", method = RequestMethod.GET)
	public List<SurveyResultData> getSurveyOneResults() {
		return service.getSurveyOneResults();
	}
	
	@RequestMapping(value = "/survey2", method = RequestMethod.GET)
	public List<SurveyResultData> getSurveyTwoResults() {
		return service.getSurveyTwoResults();
	}
}
