package com.booth.dao;

import com.booth.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @InterfaceName: ProductRepository
 * @Description:TODO
 * @Version:1.0
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
