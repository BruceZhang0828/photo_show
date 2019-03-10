package com.zhangran.photo_show.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterDTO {
    @NotBlank(message="手机号不能为空")
    private String mobile;
    @NotBlank(message="密码不能为空")
    private String password;

    @NotBlank(message="用户名不能为空")
    private String username;
}