package com.booth.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName: Order
 * @Description:TODO
 * @Version:1.0
 */
@Entity(name = "shop_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@JSONField(ordinal = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	private Integer uid;
	private String username;

	private Integer pid;
	private String pname;
	private Double pprice;

	private Integer number; //购买数量
}
