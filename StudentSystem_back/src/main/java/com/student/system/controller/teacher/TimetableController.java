package com.student.system.controller.teacher;

import com.student.system.config.themis.annotation.Teacher;
import com.student.system.controller.BaseController;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.teacher.TimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//老师课表
@Teacher
@RequestMapping("/teacher/timetable")
@RestController
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
