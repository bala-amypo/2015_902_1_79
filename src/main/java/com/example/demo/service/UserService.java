package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;

public interface UserService {
    User register(User user) throws IllegalArgumentException;
    User findByEmail(String email) throws ResourceNotFoundException;
    User findById(Long userId) throws ResourceNotFoundException;
}