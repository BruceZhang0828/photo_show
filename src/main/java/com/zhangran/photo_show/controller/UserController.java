package com.zhangran.photo_show.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhangran.photo_show.entity.UserEntity;
import com.zhangran.photo_show.form.ChangePasswordDTO;
import com.zhangran.photo_show.form.LoginDTO;
import com.zhangran.photo_show.form.RegisterDTO;
import com.zhangran.photo_show.service.UserService;
import com.zhangran.photo_show.utils.Response;
import com.zhangran.photo_show.utils.ValidatorUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;

/**
 * 用户表
 *
 * @author zhangran
 * @email zhangran@gmail.com
 * @date 2019-03-02 09:57:55
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 注册
     */
    @PostMapping("/register")
    public Response ave(RegisterDTO registerDTO) {
        //表单校验
        ValidatorUtils.validateEntity(registerDTO);
        EntityWrapper<UserEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("username", registerDTO.getUsername());
        UserEntity user = userService.selectOne(wrapper);
        if(user != null){
            return new Response("0", "用户名已存在");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(registerDTO, userEntity);
        userEntity.setPassword(DigestUtils.sha256Hex(userEntity.getPassword()));
        boolean insert = userService.insert(userEntity);
        Response response = new Response("1", "注册成功");
        response.setData(userEntity);
        return response;
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Response update(LoginDTO loginDTO) {
        ValidatorUtils.validateEntity(loginDTO);
        EntityWrapper<UserEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("username", loginDTO.getUsername());
        UserEntity user = userService.selectOne(wrapper);
        if(user == null){
            return new Response("0", "用户不存在");
        }
        String password = DigestUtils.sha256Hex(loginDTO.getPassword());
        if(!user.getPassword().equals(password)){
            return new Response("0", "密码错误");
        }
        Response response = new Response("1", "登录成功");
        response.setData(user);
        //response.setData(new Cookie("userid",user.getId().toString()));
        return response;
    }

    /**
     * 修改密码
     */
    @PostMapping("/changePassword")
    public Response changePassword(ChangePasswordDTO passwordDTO) {
        ValidatorUtils.validateEntity(passwordDTO);
        UserEntity user = userService.selectById(passwordDTO.getUserId());
        if(user == null){
            return new Response("0", "用户不存在");
        }
        String oldPassword = DigestUtils.sha256Hex(passwordDTO.getOldPassword());
        if(!user.getPassword().equals(oldPassword)){
            return new Response("0", "旧密码错误");
        }
        user.setPassword(DigestUtils.sha256Hex(passwordDTO.getNewPassword()));
        return new Response("1", "密码修改成功");
    }
}
