package com.student.system.manager.student;

import com.student.system.dao.StudentCourseDAO;
import com.student.system.manager.BaseManager;
import com.student.system.model.entity.StudentCourseEntity;
import com.student.system.model.vo.response.table.StudentCourseSelectedItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

//课程管理组件
@Component("student_CourseManager")
public class CourseManager extends BaseManager {
	//连接数据库
    private final StudentCourseDAO studentCourseDAO;

    public CourseManager(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

    //课程实体获取
    public StudentCourseEntity getStudentCourseById(Integer studentCourseId) {
        return studentCourseDAO.get(studentCourseId);
    }

    //展示已选择课程
    public List<StudentCourseSelectedItemVO> listStudentCourseSelected(Integer studentId) {
        return studentCourseDAO.listStudentCourseSelected(studentId);
    }
}
