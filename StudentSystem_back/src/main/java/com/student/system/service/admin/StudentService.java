package com.student.system.service.admin;

import com.student.system.manager.admin.StudentManager;
import com.student.system.model.entity.StudentEntity;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.BaseService;
import com.student.system.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService {
    private final StudentManager manager;

    public StudentService(StudentManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(String majorName,String name) {
        return result(manager.getPageCount(majorName, name));
    }

    public ResultVO getPage(Integer index, String majorName, String name) {
        return result(manager.getPage(index, majorName, name));
    }

    public ResultVO get(Integer id) {
        StudentEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("学生Id: " + id + "不存在!");
        }

        entity.setPassword("");

        return result(entity);
    }

    public ResultVO update(StudentEntity entity) {
        StudentEntity origin = manager.get(entity.getId());
        if (origin == null) {
            return failedResult("学生Id: " + entity.getId() + "不存在!");
        }
        if (manager.getMajorById(entity.getMajorId()) == null) {
            return failedResult("所属专业Id: " + entity.getMajorId() + "不存在!");
        }

        if (entity.getPassword().equals("")) {
            entity.setPassword(origin.getPassword());
        } else {
            entity.setPassword(entity.getPassword());
        }

        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        if (manager.get(id) == null) {
            return failedResult("学生Id: " + id + "不存在!");
        }
        if (manager.hasStudentCourse(id)) {
            return failedResult("此学生还有未退选课程");
        }

        manager.delete(id);
        return result("删除成功");
    }

    public ResultVO create(StudentEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("学生Id: " + entity.getId() + "已存在!");
        }
        if (manager.getMajorById(entity.getMajorId()) == null) {
            return failedResult("所属专业Id: " + entity.getMajorId() + "不存在!");
        }

        manager.create(entity);
        return result("添加成功");
    }

    public ResultVO listName() {
        return result(manager.listName());
    }
}
