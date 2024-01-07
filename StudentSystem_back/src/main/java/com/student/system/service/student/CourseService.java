package com.student.system.service.student;

import com.student.system.manager.student.CourseManager;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.BaseService;
import org.springframework.stereotype.Service;

//课程服务
@Service("student_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;

    public CourseService(CourseManager manager) {
        this.manager = manager;
    }

    //展示课程
    public ResultVO list() {
        Integer studentId = getUserId();
        System.out.print(result(manager.listStudentCourseSelected(studentId)).getMessage());
        System.out.print(result(manager.listStudentCourseSelected(studentId)).getMessage());
        return result(manager.listStudentCourseSelected(studentId));
    }
}
