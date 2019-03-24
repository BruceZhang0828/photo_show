package com.zhangran.photo_show.controller;

import com.zhangran.photo_show.service.CategoryService;
import com.zhangran.photo_show.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: CategoryController
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/3/17 22:40
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public Response list(Model model){
        Response response = new Response();
        //model.addAttribute("categories",categoryService.findList());
        try {
            response.setData(categoryService.findList());
            response.setCode("0");
            response.setMsg("查询成功");
        }catch (Exception e){
            //response.setData(categoryService.findList());
            response.setCode("1");
            response.setMsg("查询失败");
        }
        return response;
    }
}
