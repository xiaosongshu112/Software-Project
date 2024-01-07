package com.student.system.service.teacher;

import com.student.system.manager.teacher.TimetableManager;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.BaseService;
import org.springframework.stereotype.Service;

//课表服务
@Service
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer teacherId = getUserId();
        return result(manager.listTeacherTimetable(teacherId));
    }
}
