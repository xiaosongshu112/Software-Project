package com.student.system.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@TableName("rc_course")
@Data
public class CourseEntity {
    public static final String ID = "course_id";
    public static final String TEACHER_ID = "course_teacher_id";
    public static final String NAME = "course_name";
    public static final String TIME = "course_time";
    public static final String LOCATION = "course_location";
    public static final String TYPE = "course_type";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择授课教师")
    @TableField(TEACHER_ID)
    private Integer teacherId;

    @NotBlank(message = "课程名不能为空")
    @TableField(NAME)
    private String name;

    @Pattern(regexp = "[1-7]-[1-9]-[1-4]", message = "课程最长时间为4节")
    @TableField(TIME)
    private String time;

    @NotBlank(message = "上课地点不能为空")
    @TableField(LOCATION)
    private String location;
}
