package com.zhangran.photo_show.controller;

import com.zhangran.photo_show.service.CategoryImageService;
import com.zhangran.photo_show.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-17 21:38:43
 */
@RestController
@RequestMapping("categoryimage")
public class CategoryImageController {
    @Autowired
    private CategoryImageService categoryImageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryImageService.queryPage(params);
        return page;
    }

}
