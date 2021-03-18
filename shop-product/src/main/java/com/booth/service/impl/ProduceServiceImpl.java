package com.booth.service.impl;

import com.booth.dao.ProductRepository;
import com.booth.domain.Product;
import com.booth.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ProduceServiceImpl
 * @Description:TODO
 * @Version:1.0
 */
@Service
public class ProduceServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findByid(Integer pid) {
		return productRepository.findById(pid).get();
	}
}
