package com.zhangran.photo_show.controller;


import com.zhangran.photo_show.entity.OrderEntity;
import com.zhangran.photo_show.service.OrderService;
import com.zhangran.photo_show.utils.PageResponse;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 12:44:54
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    /**
     * 保存
     */

    @PostMapping(value = "/save")
    public Response save(OrderEntity order) {

       /* if(order.getUserId() == null){
            return new Response("0", "用户不能为空");
        }
        if(StringUtils.isBlank(order.getMobile())){
            return new Response("0", "手机号不能为空");
        }
        reservation.setCreatDate(new Date());
        reservationService.insert(reservation);*/
        return new Response("1", "预约成功");
    }

    @RequestMapping("/list")
    public PageResponse list(@RequestParam Map<String, Object> params){
        PageUtils  page = orderService.queryPage(params);
        PageResponse response = new PageResponse("0","查询成功");
        response.setData(page.getList());
        response.setCount(page.getTotalCount());
        return response;
    }

    @RequestMapping("/update")
    public Response update(@RequestParam String id){
        boolean b = orderService.updateStateById(id);
        Response response = new Response();
        response.setData(b);
        return response;
    }

}
