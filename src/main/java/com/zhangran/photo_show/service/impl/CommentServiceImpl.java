package com.zhangran.photo_show.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.CommentDao;
import com.zhangran.photo_show.dao.OrderDao;
import com.zhangran.photo_show.entity.CommentEntity;
import com.zhangran.photo_show.entity.OrderEntity;
import com.zhangran.photo_show.service.CommentService;
import com.zhangran.photo_show.service.OrderService;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements CommentService {

}
