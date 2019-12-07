package com.spring.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： yu Liu
 * @date： 2019/12/7 0007 21:38
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot!";
    }
}
