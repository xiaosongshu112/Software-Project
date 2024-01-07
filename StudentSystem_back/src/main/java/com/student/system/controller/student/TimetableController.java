package com.student.system.controller.student;

import com.student.system.config.themis.annotation.Student;
import com.student.system.controller.BaseController;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.student.TimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//学生课表
@Student
@RequestMapping("/student/timetable")
@RestController("student_timeTableController")
public class TimetableController extends BaseController {
    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @RequestMapping
    public ResultVO get() {
        return service.get();
    }
}
