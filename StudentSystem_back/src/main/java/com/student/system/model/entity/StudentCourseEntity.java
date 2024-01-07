package com.student.system.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


@TableName("t_student_course")
@Data
public class StudentCourseEntity {
    public static final String ID = "sc_id";
    public static final String STUDENT_ID = "sc_student_id";
    public static final String COURSE_ID = "sc_course_id";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择学生")
    @TableField(STUDENT_ID)
    private Integer studentId;

    @NotNull(message = "必须选择课程")
    @TableField(COURSE_ID)
    private Integer courseId;
}
