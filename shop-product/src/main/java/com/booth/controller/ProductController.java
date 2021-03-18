package com.booth.controller;

import com.alibaba.fastjson.JSON;
import com.booth.domain.Product;
import com.booth.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.validator.ValidateWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ProductController
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/product/{pid}")
	public Product product(@PathVariable("pid") Integer pid){
		log.info("商品ID",pid);
		Product product = productService.findByid(pid);
		log.info("product info"+ JSON.toJSONString(product));
		return product;
	}
}
