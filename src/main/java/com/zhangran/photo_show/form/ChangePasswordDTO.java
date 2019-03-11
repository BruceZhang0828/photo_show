package com.zhangran.photo_show.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ChangePasswordDTO {

    @NotNull(message="用户ID不能为空")
    private Long userId;
    @NotBlank(message="旧密码不能为空")
    private String oldPassword;
    @NotBlank(message="新密码不能为空")
    private String newPassword;
}