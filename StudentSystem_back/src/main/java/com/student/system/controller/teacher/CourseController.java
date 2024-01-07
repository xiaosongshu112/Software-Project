package com.student.system.controller.teacher;

import com.student.system.config.themis.annotation.Teacher;
import com.student.system.controller.BaseController;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.teacher.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/course")
@RestController("teacher_courseController")
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
