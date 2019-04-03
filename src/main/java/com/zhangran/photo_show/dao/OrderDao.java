package com.zhangran.photo_show.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhangran.photo_show.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-04-03 00:01:43
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
