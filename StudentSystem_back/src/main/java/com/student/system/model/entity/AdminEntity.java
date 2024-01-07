package com.student.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.student.system.config.themis.annotation.Admin;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//管理员实体
@TableName("t_admin")
@Data
public class AdminEntity {
    public static final String ID = "admin_id";
    public static final String USERNAME = "admin_username";
    public static final String PASSWORD = "admin_password";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @TableField(USERNAME)
    private String username;

    @NotNull
    @TableField(PASSWORD)
    private String password;
}
