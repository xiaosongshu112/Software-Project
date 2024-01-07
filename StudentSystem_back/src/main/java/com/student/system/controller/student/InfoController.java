package com.student.system.controller.student;

import com.student.system.config.themis.annotation.Student;
import com.student.system.controller.BaseController;
import com.student.system.model.vo.request.StudentInfoFormVO;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.student.InfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//学生信息
@Student
@RequestMapping("/student/info")
@RestController
public class InfoController extends BaseController {
    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO formVO) {
        return service.update(formVO);
    }
}
