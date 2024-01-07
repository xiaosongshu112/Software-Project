package com.student.system.model.vo.response.table;

import lombok.Data;

@Data
public class CourseItemVO {
    private Integer id;
    private String name;
    private String teacherName;
    private String departmentName;
    private String time;
}
