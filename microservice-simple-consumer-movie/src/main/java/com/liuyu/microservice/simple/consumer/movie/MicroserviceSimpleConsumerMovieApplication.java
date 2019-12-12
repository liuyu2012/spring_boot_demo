package com.liuyu.microservice.simple.consumer.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *  跨域访问的使用
 * @author Administrator
 */
@SpringBootApplication
public class MicroserviceSimpleConsumerMovieApplication {


//	跨域访问使用
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleConsumerMovieApplication.class, args);
	}

}
