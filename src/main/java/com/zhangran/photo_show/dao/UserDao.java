package com.zhangran.photo_show.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhangran.photo_show.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 09:57:55
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
