package com.zhangran.photo_show.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhangran.photo_show.entity.CategoryImageEntity;
import com.zhangran.photo_show.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-17 21:38:43
 */
public interface CategoryImageService extends IService<CategoryImageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

