package com.zhangran.photo_show.controller;


import com.zhangran.photo_show.entity.CommentEntity;
import com.zhangran.photo_show.entity.OrderEntity;
import com.zhangran.photo_show.entity.ReservationEntity;
import com.zhangran.photo_show.service.CommentService;
import com.zhangran.photo_show.service.OrderService;
import com.zhangran.photo_show.service.ReservationService;
import com.zhangran.photo_show.utils.PageResponse;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;


/**
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 12:44:54
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private OrderService orderService;


    /**
     * 保存
     */

    @PostMapping(value = "/save")
    public Response save(CommentEntity comment) {

        if(comment.getUserId() == null){
            return new Response("0", "用户不能为空");
        }
        if(StringUtils.isBlank(comment.getContent())){
            return new Response("0", "评论内容不能为空");
        }
        comment.setCreatDate(new Date());
        commentService.insert(comment);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(comment.getOrderId());
        orderEntity.setState(1);
        orderService.updateById(orderEntity);
        return new Response("1", "评论成功");
    }


}
