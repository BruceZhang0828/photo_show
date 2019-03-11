package com.zhangran.photo_show.controller;


import com.zhangran.photo_show.entity.ReservationEntity;
import com.zhangran.photo_show.service.ReservationService;
import com.zhangran.photo_show.utils.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 12:44:54
 */
@RestController
@RequestMapping("reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;


    /**
     * 保存
     */
    @RequestMapping("/save")
    public Response save(@RequestBody ReservationEntity reservation) {

        if(reservation.getUserId() == null){
            return new Response("0", "用户不能为空");
        }
        if(StringUtils.isNotBlank(reservation.getMobile())){
            return new Response("0", "手机号不能为空");
        }
        reservation.setCreatDate(new Date());
        reservationService.insert(reservation);

        return new Response("1", "预约成功");
    }

}
