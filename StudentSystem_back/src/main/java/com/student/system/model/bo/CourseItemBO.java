package com.student.system.model.bo;

import lombok.Data;

@Data
public class CourseItemBO {
    private Integer id;
    private String name;
    private String teacherName;
    private String departmentName;
    private String time;
}
