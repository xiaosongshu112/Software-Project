package com.student.system.manager.student;

import com.student.system.dao.StudentDAO;
import com.student.system.manager.BaseManager;
import com.student.system.model.entity.StudentEntity;
import com.student.system.model.vo.response.StudentInfoVO;
import org.springframework.stereotype.Component;

//信息管理组件
@Component
public class InfoManager extends BaseManager {
	//连接数据库
    private final StudentDAO studentDAO;

    public InfoManager(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentInfoVO getStudentInfoByStudentId(Integer studentId) {
        return studentDAO.getStudentInfoById(studentId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }

    public int updateStudent(StudentEntity entity) {
        return studentDAO.update(entity);
    }
}
