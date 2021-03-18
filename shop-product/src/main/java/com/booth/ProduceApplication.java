package com.booth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @ClassName: ProduceApplication
 * @Description:TODO
 * @Version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProduceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProduceApplication.class,args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}
}
