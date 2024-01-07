package com.student.system.service.admin;

import com.student.system.manager.admin.StudentCourseManager;
import com.student.system.model.entity.StudentCourseEntity;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService extends BaseService {
    private final StudentCourseManager manager;

    public StudentCourseService(StudentCourseManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(String className, String courseName, String studentName) {
        return result(manager.getPageCount(className, courseName, studentName));
    }

    public ResultVO getPage(Integer index, String className, String courseName, String studentName) {
        return result(manager.getPage(index, className, courseName, studentName));
    }

    public ResultVO get(Integer id) {
        StudentCourseEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("学生选课Id: " + id + "不存在!");
        }

        return result(entity);
    }

    public ResultVO update(StudentCourseEntity entity) {
        StudentCourseEntity originEntity = manager.get(entity.getId());
        if (originEntity == null) {
            return failedResult("学生选课Id: " + entity.getId() + "不存在!");
        }
        if (!originEntity.getCourseId().equals(entity.getCourseId())) {
            return failedResult("课程Id被篡改");
        }
        if (!originEntity.getStudentId().equals(entity.getStudentId())) {
            return failedResult("学生Id被篡改");
        }

        manager.update(entity);
        return result("更新成功");
    }
}
