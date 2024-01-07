package com.student.system.model.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class StudentInfoFormVO {
    private String password;
    @Range(min = 0, max = 1)
    private Integer sex;
}
