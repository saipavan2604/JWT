package com.youtube.jwt.dao;

import com.youtube.jwt.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
    User findByUserName(String userName);
}
