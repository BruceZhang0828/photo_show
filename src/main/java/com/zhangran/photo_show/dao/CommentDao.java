package com.zhangran.photo_show.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhangran.photo_show.entity.CommentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论表
 * 
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 14:10:40
 */
@Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {
	
}
