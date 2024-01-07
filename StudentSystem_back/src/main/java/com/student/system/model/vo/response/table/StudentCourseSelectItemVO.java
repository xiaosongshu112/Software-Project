package com.student.system.model.vo.response.table;

import lombok.Data;

@Data
public class StudentCourseSelectItemVO {
    private Integer courseId;
    private String courseName;
    private String teacherName;
    private String time;
}
