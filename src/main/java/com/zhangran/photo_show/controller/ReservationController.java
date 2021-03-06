package com.zhangran.photo_show.controller;


import com.zhangran.photo_show.entity.ReservationEntity;
import com.zhangran.photo_show.service.ReservationService;
import com.zhangran.photo_show.utils.PageResponse;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;


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

    @PostMapping(value = "/save")
    public Response save(ReservationEntity reservation) {

        if(reservation.getUserId() == null){
            return new Response("0", "用户不能为空");
        }
        if(StringUtils.isBlank(reservation.getMobile())){
            return new Response("0", "手机号不能为空");
        }
        reservation.setCreatDate(new Date());
        reservation.setState(0);
        reservation.setEarnestMoney(new BigDecimal(0.01));
        reservationService.insert(reservation);
        return new Response("1", "预约成功");
    }

    @RequestMapping("/list")
    public PageResponse list(@RequestParam Map<String, Object> params){
        PageUtils  page = reservationService.queryPage(params);
        PageResponse response = new PageResponse("0","查询成功");
        response.setData(page.getList());
        response.setCount(page.getTotalCount());
        return response;
    }

    @RequestMapping("/update")
    public Response update(@RequestParam String id){
        boolean b = reservationService.updateStateById(id);
        Response response = new Response();
        response.setData(b);
        return response;
    }

}
