package com.student.system.model.vo.response;

import lombok.Data;

@Data
public class StudentInfoVO {
    private String number;
    private String name;
    private String departmentName;
    private String majorName;
    private String className;
    private Integer sex;
}
