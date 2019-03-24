package com.zhangran.photo_show.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.ReservationDao;
import com.zhangran.photo_show.entity.ReservationEntity;
import com.zhangran.photo_show.service.ReservationService;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("reservationService")
public class ReservationServiceImpl extends ServiceImpl<ReservationDao, ReservationEntity> implements ReservationService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String userId = (String) params.get("userId");
        Page<ReservationEntity> page = this.selectPage(
                new Query<ReservationEntity>(params).getPage(),
                new EntityWrapper<ReservationEntity>()
                .eq(StringUtils.isNotBlank(userId), "user_id", userId)
        );

        return new PageUtils(page);
    }

    @Override
    public boolean updateStateById(String id) {
        ReservationEntity entity = new ReservationEntity();
        entity.setId(Long.valueOf(id));
        entity.setState(2);
        boolean b = this.updateById(entity);
        return b;
    }
}
