package com.zhangran.photo_show.service;


import com.baomidou.mybatisplus.service.IService;
import com.zhangran.photo_show.entity.ImageEntity;
import com.zhangran.photo_show.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-08 21:09:45
 */
public interface ImageService extends IService<ImageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

