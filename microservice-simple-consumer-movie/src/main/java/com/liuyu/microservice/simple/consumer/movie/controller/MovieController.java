package com.liuyu.microservice.simple.consumer.movie.controller;

import com.liuyu.microservice.simple.consumer.movie.bo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author： yu Liu
 * @date： 2019/12/12 0012 14:46
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
public class MovieController {

    private final RestTemplate restTemplate;

    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable String id) {
        return restTemplate.getForObject("http://localhost:8000/" + id, User.class);
    }
}
