package com.student.system.service.student;

import com.student.system.manager.student.TimetableManager;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.BaseService;
import org.springframework.stereotype.Service;

//课表服务
@Service("student_timetableService")
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer studentId = getUserId();
        return result(manager.listStudentTimetable(studentId));
    }
}
