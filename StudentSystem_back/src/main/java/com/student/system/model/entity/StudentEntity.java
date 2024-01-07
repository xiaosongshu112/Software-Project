package com.student.system.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@TableName("t_student")
@Data
public class StudentEntity {
    public static final String ID = "student_id";
    public static final String MAJOR_ID = "student_major_id";
    public static final String NUMBER = "student_number";
    public static final String NAME = "student_name";
    public static final String PASSWORD = "student_password";
    public static final String SEX = "student_sex";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择所属专业")
    @TableField(MAJOR_ID)
    private Integer majorId;

    @Length(min = 12, max = 12, message = "学号长度必须为12位")
    @TableField(NUMBER)
    private String number;

    @NotBlank(message = "学生姓名不能为空")
    @TableField(NAME)
    private String name;

    @NotNull
    @TableField(PASSWORD)
    private String password;

    @Range(min = 0, max = 1)
    @TableField(SEX)
    private Integer sex;
}
