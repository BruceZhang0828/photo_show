package com.zhangran.photo_show.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.CommentDao;
import com.zhangran.photo_show.dao.OrderDao;
import com.zhangran.photo_show.dao.ReservationDao;
import com.zhangran.photo_show.entity.OrderEntity;
import com.zhangran.photo_show.entity.ReservationEntity;
import com.zhangran.photo_show.service.OrderService;
import com.zhangran.photo_show.service.ReservationService;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Query;
import com.zhangran.photo_show.vo.OrderVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {
    @Autowired
    CommentDao commentDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String userId = (String) params.get("userId");
        Page<OrderEntity> page = this.selectPage(
                new Query<OrderEntity>(params).getPage(),
                new EntityWrapper<OrderEntity>()
                .eq(StringUtils.isNotBlank(userId), "user_id", userId)
        );
        List<OrderEntity> records = page.getRecords();
        List<OrderVo> orderVos = new ArrayList<>();
        for (OrderEntity orderEntity:records){
            OrderVo orderVo = new OrderVo();
            BeanUtils.copyProperties(orderEntity,orderVo);
            if (orderEntity.getState()==1){
                orderVo.setContent(commentDao.selectContentByOrderId(orderEntity.getId()));
            }else{
                orderVo.setContent("无评价");
            }
            orderVos.add(orderVo);
        }
        Page<OrderVo> orderVoPage = new Page<>();
        orderVoPage.setRecords(orderVos);
        orderVoPage.setTotal(page.getTotal());
        orderVoPage.setCurrent(page.getCurrent());
        orderVoPage.setSize(page.getSize());
        return new PageUtils(orderVoPage);
    }

    @Override
    public boolean updateStateById(String id) {
        OrderEntity entity = new OrderEntity();
        entity.setId(Long.valueOf(id));
        boolean b = this.updateById(entity);
        return b;
    }
}
