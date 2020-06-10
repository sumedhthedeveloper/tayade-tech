package com.tayadetech.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Rating {

	@NotNull
	@Size(min = 8, message = "Vehicle Registration Number should have at least 8 characters")
	 //@Min(8)
	private String moviesId;
	//@NotEmpty
	//@Size(min = 8, message = "Vehicle Registration Number should have at least 8 characters")
	private int rating;
	
	public Rating() {}
		
	public Rating(String moviesId, int rating) {
		super();
		this.moviesId = moviesId;
		this.rating = rating;
	}
	
	public String getMoviesId() {
		return moviesId;
	}
	public void setMoviesId(String moviesId) {
		this.moviesId = moviesId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
