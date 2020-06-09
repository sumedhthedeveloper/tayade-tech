package com.tayadetech.model;

public class Rating {

	private String moviesId;
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
