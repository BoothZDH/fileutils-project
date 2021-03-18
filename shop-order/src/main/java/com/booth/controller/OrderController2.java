package com.booth.controller;

import com.alibaba.fastjson.JSON;
import com.booth.domain.Order;
import com.booth.domain.Product;
import com.booth.service.OrderService;
import com.booth.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: OrderController2
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
//@RestController
public class OrderController2 {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private ProductService productService;

	@RequestMapping("/order/prod/{pid}")
	public Order createOrder(@PathVariable("pid") Integer pid){
		log.info("用户下单的商品的" + pid);
		Product product = productService.findById(pid);

		//模拟下单时间
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log.info("获取到的商品信息"+ JSON.toJSONString(product));

		Order order = new Order();
		order.setUid(1);
		order.setUsername("testUser");
		order.setPid(pid);
		order.setPname(product.getPname());
		order.setPprice(product.getPprice());
		order.setNumber(1);

		//orderService.createOrder(order);

		log.info("order info"+ JSON.toJSONString(order));
		return order;
	}

	@RequestMapping("/order/message")
	public String message(){
		log.info("test----");
		return "测试高并发";
	}
}
