package com.booth.myplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.booth.myplus.entiy.User;
import com.booth.myplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/15/14:18
 * @Description: //TODO
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {


}
