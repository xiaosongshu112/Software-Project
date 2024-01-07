package com.student.system.manager.admin;

import com.student.system.dao.MajorDAO;
import com.student.system.dao.StudentCourseDAO;
import com.student.system.dao.StudentDAO;
import com.student.system.manager.BaseManager;
import com.student.system.model.entity.MajorEntity;
import com.student.system.model.entity.StudentEntity;
import com.student.system.model.vo.response.IdNameVO;
import com.student.system.model.vo.response.table.StudentItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//学生管理组件
@Component
public class StudentManager extends BaseManager {
	private final MajorDAO majorDAO;
    private final StudentCourseDAO studentCourseDAO;
    private final StudentDAO studentDAO;

    public StudentManager(MajorDAO majorDAO, StudentCourseDAO studentCourseDAO, StudentDAO studentDAO) {
    	this.majorDAO = majorDAO;
        this.studentCourseDAO = studentCourseDAO;
        this.studentDAO = studentDAO;
    }

    public Integer getPageCount(String majorName, String name) {
        int count = studentDAO.count(majorName, name);
        return calcPageCount(count, StudentDAO.PAGE_SIZE);
    }

    public List<StudentItemVO> getPage(Integer index, String majorName, String name) {
        return studentDAO.getPage(index, majorName, name);
    }

    public StudentEntity get(Integer id) {
        return studentDAO.get(id);
    }

    public int create(StudentEntity entity) {
        return studentDAO.insert(entity);
    }

    public int update(StudentEntity entity) {
        return studentDAO.update(entity);
    }

    public int delete(Integer id) {
        return studentDAO.delete(id);
    }
    
    public MajorEntity getMajorById(Integer majorId) {
        return majorDAO.get(majorId);
    }
    public boolean hasStudentCourse(Integer studentId) {
        return studentCourseDAO.countByStudentId(studentId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<StudentEntity> entityList = studentDAO.listName();
        for (StudentEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
