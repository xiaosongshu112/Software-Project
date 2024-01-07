package com.student.system.manager;

import org.springframework.stereotype.Component;

@Component
public class OptionManager extends BaseManager {
    private static final Boolean DEFAULT_ALLOW_STUDENT_SELECT = true;
    private static final Boolean DEFAULT_ALLOW_TEACHER_GRADE = true;

    public Boolean getAllowStudentSelect() {
        return true;
    }

    public void setAllowStudentSelect(Boolean status) {
    }

    public Boolean getAllowTeacherGrade() {
        return true;
    }

    public void setAllowTeacherGrade(Boolean status) {
    }
}
