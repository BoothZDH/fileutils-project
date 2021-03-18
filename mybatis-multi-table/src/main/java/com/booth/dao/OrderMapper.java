package com.booth.dao;

import com.booth.domain.Order;

import java.util.List;

/**
 * @ClassName: OrderMapper
 * @Description:TODO
 * @Version:1.0
 */
public interface OrderMapper {
	/**
	 * 查询所有，并返回对象集合，并且包含所有用户信息
	 * @return
	 */
	List<Order> findAll();
}
