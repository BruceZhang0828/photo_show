package com.zhangran.photo_show.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.ReservationDao;
import com.zhangran.photo_show.entity.ReservationEntity;
import com.zhangran.photo_show.service.ReservationService;
import org.springframework.stereotype.Service;

@Service("reservationService")
public class ReservationServiceImpl extends ServiceImpl<ReservationDao, ReservationEntity> implements ReservationService {


}
