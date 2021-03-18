package com.booth.controller;

import com.alibaba.fastjson.JSON;
import com.booth.domain.Order;
import com.booth.domain.Product;
import com.booth.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: OrderController2
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
@RestController
public class OrderController3 {


	@RequestMapping("/order/message1")
	public String message1(){
		log.info("test----1");
		return "测试高并发1";
	}

	@RequestMapping("/order/message2")
	public String message2(){
		log.info("test----2");
		return "测试高并发2";
	}
}
