package com.booth.controller;

import com.alibaba.fastjson.JSON;
import com.booth.domain.Order;
import com.booth.domain.Product;
import com.booth.service.OrderService;
import com.booth.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @ClassName: OrderController
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
//@RestController
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrderService orderService;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private ProductService productService;

	@RequestMapping("/order/prod/{pid}")
	public Order createOrder(@PathVariable("pid") Integer pid){
		log.info("用户下单的商品的" + pid);
		// 获取商品信息

		//从注册中心nacos上获取服务实例
//		List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//		//多实例手动均衡负载
//		int index = new Random().nextInt(instances.size());
//		ServiceInstance server = instances.get(index);

		//基于ribbon实现负载均衡
		//Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);

		//基于feign的服务调用
		Product product = productService.findById(pid);
		log.info("获取到的商品信息"+ JSON.toJSONString(product));

		Order order = new Order();
		order.setUid(1);
		order.setUsername("testUser");
		order.setPid(pid);
		order.setPname(product.getPname());
		order.setPprice(product.getPprice());
		order.setNumber(1);

		orderService.createOrder(order);
		log.info("order info"+ JSON.toJSONString(order));
		return order;
	}
//
//	@RequestMapping("/order/prod/{pid}")
//	public Order createOrder(@PathVariable("pid") Integer pid){
//		log.info("用户下单的商品的" + pid);
//		// 获取商品信息
//
//		//从注册中心nacos上获取服务方法
//		List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//		ServiceInstance server = instances.get(0);
//		Product product = restTemplate.getForObject("http://"+server.getHost()+":"+server.getPort()+"/product/" + pid, Product.class);
//		log.info("获取到的商品信息"+ JSON.toJSONString(product));
//
//		Order order = new Order();
//		order.setUid(1);
//		order.setUsername("testUser");
//		order.setPid(pid);
//		order.setPname(product.getPname());
//		order.setPprice(product.getPprice());
//		order.setNumber(1);
//
//		orderService.createOrder(order);
//		log.info("order info"+ JSON.toJSONString(order));
//		return order;
//	}
}
