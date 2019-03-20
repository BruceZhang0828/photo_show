package com.zhangran.photo_show.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.CategoryDao;
import com.zhangran.photo_show.entity.CategoryEntity;
import com.zhangran.photo_show.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CategoryServiceImpl
 * @Description: TODO
 * @auther: zr
 * @Date: 2019/3/17 22:58
 * @Version: 1.0
 **/
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService{
    @Override
    public List<CategoryEntity> findList() {
        List<CategoryEntity> categoryEntities = this.selectList(new EntityWrapper<CategoryEntity>());
        return categoryEntities;
    }
}
