package com.tayadetech.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tayadetech.model.Rating;
import com.tayadetech.model.UserRating;

@Service
public class UserRatingInfoService {

	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * In Which case: @HystrixCommand will not work let's see -
	 * Proxy class - API Class - @HystrixCommand annotated method - Proxy Class is calling API Class and API Class is calling @HystrixCommand 
	 * 																annotated method which has an instance of API Class and API Class has 
	 * 																an instance of Proxy Class. In this case @HystrixCommand annotated method
	 * 																being called by Proxy Class which has power to call 'Circuit Breaker' bcoz
	 * 																main Class is annotated with  @EnableCircuitBreaker Annotation.
	 * 																
	 * 
	 * Proxy class - API Class - Method() - @HystrixCommand annotated method -  Proxy Class is calling API Class and API Class is calling Method()
	 * 																and Method() is calling @HystrixCommand annotated method.In this case 
	 * 																@HystrixCommand annotated method being called by Method() not by Proxy Class 
	 * 																that's why 'Circuit Breaker' will not work.
	 */	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating",
					commandProperties = {
							@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
							@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
							@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
							@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
					},
			threadPoolKey = "ratingInfoPool", /* this is part of bulkheadpattern */
					threadPoolProperties = { /* this is part of bulkheadpattern */	
							@HystrixProperty(name = "coreSize", value = "20"),
							@HystrixProperty(name = "maxQueueSize", value = "10")
					}
				  ) // For timeout (If one of the service is down or not getting response)
	public UserRating getUserRating(@PathVariable("userId") String userId)
	{
		return restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRating.class);
	}
	
	public UserRating getFallbackUserRating(@PathVariable("userId") String userId)
	{
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setUserRating(Arrays.asList(
				new Rating("",0)
				));
		return userRating;
	}
}
