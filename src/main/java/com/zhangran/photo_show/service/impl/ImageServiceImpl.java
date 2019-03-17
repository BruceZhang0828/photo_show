package com.zhangran.photo_show.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhangran.photo_show.dao.ImageDao;
import com.zhangran.photo_show.entity.ImageEntity;
import com.zhangran.photo_show.service.ImageService;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("imageService")
public class ImageServiceImpl extends ServiceImpl<ImageDao, ImageEntity> implements ImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ImageEntity> page = this.selectPage(
                new Query<ImageEntity>(params).getPage(),
                new EntityWrapper<ImageEntity>().eq(params.get("uploadId") != null,"upload_id", params.get("uploadId"))
        );

        return new PageUtils(page);
    }

}
