package com.zhangran.photo_show.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.ReservationDao;
import com.zhangran.photo_show.entity.ReservationEntity;
import com.zhangran.photo_show.service.ReservationService;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("reservationService")
public class ReservationServiceImpl extends ServiceImpl<ReservationDao, ReservationEntity> implements ReservationService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ReservationEntity> page = this.selectPage(
                new Query<ReservationEntity>(params).getPage(),
                new EntityWrapper<ReservationEntity>()
        );

        return new PageUtils(page);
    }
}
