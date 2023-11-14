package com.youtube.jwt.controller;

import com.youtube.jwt.entity.Feedback;
import com.youtube.jwt.entity.FeedbackReq;
import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.FeedbackService;
import com.youtube.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.PostConstruct;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FeedbackService feedbackService;

    
    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
    
    
    @PostMapping("/feedback")
    @PreAuthorize("hasRole('User')")
    public Feedback forUserFeedback(@RequestBody FeedbackReq feedbackreq) {
    	Feedback feedback=new Feedback();
        // Assuming the username is provided in the `feedback` object
        String username = feedbackreq.getUsername();
        System.out.print(username);
        // Retrieve the user based on the username
        User user = userService.getUserByName(username);
        feedback.setComment(feedbackreq.getComment());
        feedback.setRating(feedbackreq.getRating());
        // Set the user in the feedback
        feedback.setUser(user);

        // Save the feedback
        return feedbackService.saveFeedback(feedback);
    }

    
    
    
    
    @GetMapping("/myfeedback/{username}")
    @PreAuthorize("hasRole('User')")
    public List<Feedback> getUserFeedback(@PathVariable String username) {
        // Implement logic to retrieve feedback for the specified user based on their username
        // You can use a service method to fetch the feedback by the username
        return feedbackService.getFeedbackByUserUsername(username);
    }


    
    @GetMapping("/allfeedbacks")
    @PreAuthorize("hasRole('Admin')")
    public List<Feedback> getAllFeedback() {
        // Implement logic to retrieve feedback for the specified user based on their username
        // You can use a service method to fetch the feedback by the username
        return feedbackService.getAllFeedback();
    }

    
}
