package com.booth.service.impl;

import com.booth.dao.OrderRepository;
import com.booth.domain.Order;
import com.booth.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OrderServiceImpl
 * @Description:TODO
 * @Version:1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void createOrder(Order order) {

		orderRepository.save(order);
	}
}
