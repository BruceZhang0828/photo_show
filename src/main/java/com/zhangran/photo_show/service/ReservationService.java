package com.zhangran.photo_show.service;


import com.baomidou.mybatisplus.service.IService;
import com.zhangran.photo_show.entity.ReservationEntity;
import com.zhangran.photo_show.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 12:44:54
 */
public interface ReservationService extends IService<ReservationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

