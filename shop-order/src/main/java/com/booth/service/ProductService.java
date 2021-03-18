package com.booth.service;

import com.booth.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @InterfaceName: ProductService
 * @Description:TODO
 * @Version:1.0
 */
@Component
@FeignClient(value = "service-product")  //提供者的host和Port
public interface ProductService {

	@RequestMapping(value = "/product/{pid}")  //需要调用的方法和参数
	Product findById(@PathVariable("pid") Integer pid);
}
