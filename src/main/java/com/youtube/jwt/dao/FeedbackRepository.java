package com.youtube.jwt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.jwt.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // You can add custom query methods here if needed
    List<Feedback> findByUserUserName(String username);

}
