package com.student.system.service;

import com.student.system.manager.OptionManager;
import com.student.system.model.vo.response.ResultVO;
import org.springframework.stereotype.Service;

@Service
public class OptionService extends BaseService {
    private final OptionManager manager;

    public OptionService(OptionManager manager) {
        this.manager = manager;
    }

    public ResultVO setAllowStudentSelect(Boolean status) {
        manager.setAllowStudentSelect(status);
        return result("成功");
    }

    public ResultVO getAllowStudentSelect() {
        return result(manager.getAllowStudentSelect());
    }

    public ResultVO setAllowTeacherGrade(Boolean status) {
        manager.setAllowTeacherGrade(status);
        return result("成功");
    }

    public ResultVO getAllowTeacherGrade() {
        return result(manager.getAllowTeacherGrade());
    }
}
