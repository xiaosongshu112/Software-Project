package com.student.system.model.bo;

import lombok.Data;

@Data
public class StudentCourseSelectItemBO {
    private Integer courseId;
    private String courseName;
    private String teacherName;
    private String time;
}
