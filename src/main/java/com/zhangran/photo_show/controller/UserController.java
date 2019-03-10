package com.zhangran.photo_show.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhangran.photo_show.entity.UserEntity;
import com.zhangran.photo_show.form.LoginDTO;
import com.zhangran.photo_show.form.RegisterDTO;
import com.zhangran.photo_show.service.UserService;
import com.zhangran.photo_show.utils.Response;
import com.zhangran.photo_show.utils.ValidatorUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 保存
     */
    @PostMapping("/register")
    public Response save(@RequestBody RegisterDTO registerDTO) {
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
        userService.insert(userEntity);

        return new Response("1", "注册成功");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Response<UserEntity> update(@RequestBody LoginDTO loginDTO) {
        ValidatorUtils.validateEntity(loginDTO);
        EntityWrapper<UserEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("username", loginDTO.getUsername());
        UserEntity user = userService.selectOne(wrapper);
        if(user == null){
            return new Response<>("0", "用户不存在");
        }
        String password = DigestUtils.sha256Hex(loginDTO.getPassword());
        if(!user.getPassword().equals(password)){
            return new Response<>("0", "密码错误");
        }
        return new Response<>("1", "登录成功", user);
    }

}
