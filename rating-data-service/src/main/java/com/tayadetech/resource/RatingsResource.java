package com.tayadetech.resource;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tayadetech.model.Rating;
import com.tayadetech.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{moviesId}")
	public Rating getRating(@PathVariable("moviesId") String moviesId)
	{
		return new Rating(moviesId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId)
	{
		List<Rating> ratings = Arrays.asList(
				
				new Rating("123",4),
				new Rating("124",4),
				new Rating("125",4)
				
				);
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
	
	@RequestMapping(value="validation", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> createVehicle(@Valid @RequestBody Rating rating){
		System.out.println("validation...");
	    return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
}
