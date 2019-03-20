package com.zhangran.photo_show.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhangran.photo_show.entity.CategoryEntity;

import java.util.List;

public interface CategoryService extends IService<CategoryEntity> {
    List<CategoryEntity> findList();
}
