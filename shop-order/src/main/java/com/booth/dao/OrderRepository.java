package com.booth.dao;

import com.booth.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName: OrderRepository
 * @Description:TODO
 * @Version:1.0
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
