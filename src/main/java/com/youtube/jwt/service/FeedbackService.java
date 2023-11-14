package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.FeedbackRepository;
import com.youtube.jwt.entity.Feedback;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepo;
	
	
	public Feedback saveFeedback(Feedback feedback) {
		
		return feedbackRepo.save(feedback);
	}
	
	
	public List<Feedback> getFeedbackByUserUsername(String username) {
	    // Implement a method that retrieves feedback for a user by their username
	    return feedbackRepo.findByUserUserName(username);
	}
	
	
	public List<Feedback> getAllFeedback() {
	    // Implement a method that retrieves feedback for a user by their username
	    return feedbackRepo.findAll();
	}
	

}
