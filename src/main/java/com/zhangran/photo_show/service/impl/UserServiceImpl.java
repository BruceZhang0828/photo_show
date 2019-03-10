package com.zhangran.photo_show.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.UserDao;
import com.zhangran.photo_show.entity.UserEntity;
import com.zhangran.photo_show.service.UserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {



}
