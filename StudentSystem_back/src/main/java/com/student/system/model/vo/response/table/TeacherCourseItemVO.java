package com.student.system.model.vo.response.table;
import lombok.Data;

@Data
public class TeacherCourseItemVO {
    private Integer id;
    private String name;
    private String time;
    private String location;
    private Integer selectedCount;
}
