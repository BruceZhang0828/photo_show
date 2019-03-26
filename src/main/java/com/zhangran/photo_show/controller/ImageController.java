package com.zhangran.photo_show.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhangran.photo_show.entity.ImageEntity;
import com.zhangran.photo_show.service.ImageService;
import com.zhangran.photo_show.utils.PageUtils;
import com.zhangran.photo_show.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-08 21:09:45
 */
@RestController
@RequestMapping("image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    /**
     * 列表分页
     */
    @RequestMapping("/page")
    public PageUtils page(@RequestParam Map<String, Object> params) {

        PageUtils page = imageService.queryPage(params);
        return page;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Response<List<ImageEntity>> list(@RequestParam Map<String, String> params) {

        String limit = params.get("limit");
        EntityWrapper<ImageEntity> wrapper = new EntityWrapper<>();
        wrapper.last("LIMIT " + limit);
        List<ImageEntity> list = imageService.selectList(wrapper);
        return new Response<>("1", "获取成功", list);
    }


}
