package com.booth.service;

import com.booth.domain.Product;

/**
 * @InterfaceName: ProductService
 * @Description:TODO
 * @Version:1.0
 */
public interface ProductService {
	Product findByid(Integer pid);
}
