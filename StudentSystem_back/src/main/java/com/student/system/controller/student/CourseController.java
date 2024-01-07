package com.student.system.controller.student;

import com.student.system.config.themis.annotation.Student;
import com.student.system.controller.BaseController;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.student.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//学生课程
@Student
@RequestMapping("/student/course")
@RestController("student_courseController")
public class CourseController extends BaseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
