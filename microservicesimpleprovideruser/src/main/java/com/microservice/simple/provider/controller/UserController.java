package com.microservice.simple.provider.controller;

import com.microservice.simple.provider.bo.User;
import com.microservice.simple.provider.dao.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author： yu Liu
 * @date： 2019/12/12 0012 13:33
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/consumer/{id}")
    public User findById(@PathVariable Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElse(null);
    }
}
