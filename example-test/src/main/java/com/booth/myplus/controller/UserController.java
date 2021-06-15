package com.booth.myplus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
;
import com.booth.common.exceptionUtils.ServiceException;
import com.booth.common.result.Result;
import com.booth.myplus.entiy.User;
import com.booth.myplus.service.IUserService;
import com.booth.stringutils.StringUtilssss;
import com.booth.web.erroCode.CodeMapping;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ClassName: UserController
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/15/14:16
 * @Description: //TODO
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;


	@GetMapping(value = "/query")
	public void query() {
		QueryWrapper qw = new QueryWrapper();
		qw.like("username","booth");
		User user = userService.getOne(qw);
		try {
			boolean save = userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(CodeMapping.ERROR_SYSTEM,"/query : Failed");
		}
		System.out.println(user.getPassword());
	}

	@PostMapping(value = "/saveBatch")
	public Result<?> saveBatshT(@RequestBody JSONObject json){
		List entiryList=new ArrayList();

		if (json.isEmpty()) {
			return Result.error("用户信息不能为空");
		}
		System.out.println(json);

		User user1 = json.getObject("user", User.class);
		System.out.println(user1);
		User user11 = json.getObject("user1", User.class);
		entiryList.add(user1);
		entiryList.add(user11);
		try {
			userService.saveOrUpdateBatch(entiryList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(CodeMapping.ERROR_PARAM_SIGN,e.getMessage());
		}


		return Result.OK();
	}


}
