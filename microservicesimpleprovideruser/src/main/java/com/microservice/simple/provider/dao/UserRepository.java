package com.microservice.simple.provider.dao;

import com.microservice.simple.provider.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author： yu Liu
 * @date： 2019/12/12 0012 13:30
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
