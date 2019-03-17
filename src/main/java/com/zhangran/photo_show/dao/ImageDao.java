package com.zhangran.photo_show.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhangran.photo_show.entity.ImageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-08 21:09:45
 */
@Mapper
public interface ImageDao extends BaseMapper<ImageEntity> {
	
}
