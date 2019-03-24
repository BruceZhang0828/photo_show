package com.zhangran.photo_show.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.CategoryImageDao;
import com.zhangran.photo_show.entity.CategoryImageEntity;
import com.zhangran.photo_show.service.CategoryImageService;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("categoryImageService")
public class CategoryImageServiceImpl extends ServiceImpl<CategoryImageDao, CategoryImageEntity> implements CategoryImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String categoryId = (String) params.get("category_id");
        Page<CategoryImageEntity> page = this.selectPage(
                new Query<CategoryImageEntity>(params).getPage(),
                new EntityWrapper<CategoryImageEntity>().eq(StringUtils.isNotBlank(categoryId)&&!("0".equals(categoryId)),"category_id",categoryId)
        );

        return new PageUtils(page);
    }

}
