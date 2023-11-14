package com.youtube.jwt.entity;

public class FeedbackReq {


	private String comment;  // The feedback comment
    private int rating;  // The rating given by the user (you can choose the appropriate data type for your ratings)
	private String username;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	} 
    
}
