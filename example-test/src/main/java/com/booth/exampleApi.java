package com.booth;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: exampleApi
 * @Description:TODO
 * @Version:1.0
 */
@SpringBootApplication
@ComponentScan("com.booth.myplus")
@MapperScan("com.booth.myplus.mapper")
public class exampleApi {
	public static void main(String[] args) {
		SpringApplication.run(exampleApi.class,args);
	}
}
