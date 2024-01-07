package com.student.system.manager;

import com.student.system.dao.AdminDAO;
import com.student.system.dao.StudentDAO;
import com.student.system.dao.TeacherDAO;
import com.student.system.model.bo.AuthInfoBO;
import com.student.system.model.constant.UserType;
import com.student.system.model.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserManager extends BaseManager {
	//数据库信息
    private final AdminDAO adminDAO;
    private final TeacherDAO teacherDAO;
    private final StudentDAO studentDAO;

    public UserManager(AdminDAO adminDAO, TeacherDAO teacherDAO, StudentDAO studentDAO) {
        this.adminDAO = adminDAO;
        this.teacherDAO = teacherDAO;
        this.studentDAO = studentDAO;
    }
    
    //获取身份信息
    public AuthInfoBO getAuthInfoByUsername(String username, Integer userType) {
        if (userType == UserType.STUDENT) //学生身份
            return AuthInfoBO.fromStudent(studentDAO.getByNumber(username));
        else if (userType == UserType.TEACHER) //老师身份
            return AuthInfoBO.fromTeacher(teacherDAO.getByNumber(username));
        else if (userType == UserType.ADMIN) //管理员身份
            return AuthInfoBO.fromAdmin(adminDAO.getByUsername(username));
        return null;
    }
}
