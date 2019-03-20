package com.zhangran.photo_show.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhangran.photo_show.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
}
