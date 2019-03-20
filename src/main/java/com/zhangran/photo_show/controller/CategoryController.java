package com.zhangran.photo_show.controller;

import com.zhangran.photo_show.service.CategoryService;
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
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        //ModelAndView map = new ModelAndView();
        model.addAttribute("categories",categoryService.findList());
        //map.setViewName("/category/category");
        return "category";
    }
}
