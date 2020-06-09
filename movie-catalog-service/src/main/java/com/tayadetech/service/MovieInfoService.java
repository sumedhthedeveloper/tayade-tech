package com.tayadetech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tayadetech.model.CatalogItem;
import com.tayadetech.model.Movie;
import com.tayadetech.model.Rating;

@Service
public class MovieInfoService {

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
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
//					commandProperties = {
//							@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
//							@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
//							@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//							@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
//					},
			threadPoolKey = "movieInfoPool", /* this is part of bulkheadpattern */
					threadPoolProperties = { /* this is part of bulkheadpattern */	
							@HystrixProperty(name = "coreSize", value = "20"),
							@HystrixProperty(name = "maxQueueSize", value = "10")
					}
				  ) // For timeout (If one of the service is down or not getting response)
	public CatalogItem getCatalogItem(Rating rating)
	{
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMoviesId(), Movie.class);	
		return new CatalogItem(movie.getName(), "Test", rating.getRating());
	}
	
	public CatalogItem getFallbackCatalogItem(Rating rating)
	{
		return new CatalogItem("Movie name not found", "", rating.getRating());
	}
}
