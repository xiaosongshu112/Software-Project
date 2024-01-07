package com.student.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.system.dao.mapper.StudentCourseMapper;
import com.student.system.model.entity.StudentCourseEntity;
import com.student.system.model.vo.response.table.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentCourseDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final StudentCourseMapper mapper;

    public StudentCourseDAO(StudentCourseMapper mapper) {
        this.mapper = mapper;
    }


    public int insert(StudentCourseEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public StudentCourseEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(StudentCourseEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String majorName, String courseName, String studentName) {
        return mapper.count(majorName, courseName, studentName);
    }

    public List<StudentCourseItemVO> getPage(Integer index,String majorName, String courseName, String studentName) {
        Page<StudentCourseItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page,majorName, courseName, studentName).getRecords();
    }

    public int countByCourseId(Integer courseId) {
        LambdaQueryWrapper<StudentCourseEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentCourseEntity::getCourseId, courseId);

        return mapper.selectCount(wrapper);
    }

    public int countByStudentId(Integer studentId) {
        LambdaQueryWrapper<StudentCourseEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentCourseEntity::getStudentId, studentId);

        return mapper.selectCount(wrapper);
    }

    public StudentCourseEntity getByCourseIdAndStudentId(Integer courseId, Integer studentId) {
        LambdaQueryWrapper<StudentCourseEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(StudentCourseEntity::getId)
                .eq(StudentCourseEntity::getCourseId, courseId)
                .eq(StudentCourseEntity::getStudentId, studentId);

        return mapper.selectOne(wrapper);
    }

    //返回课程列表
    public List<StudentCourseSelectedItemVO> listStudentCourseSelected(Integer studentId) {
        return mapper.listStudentCourseSelected(studentId);
    }

    public Integer countStudentCourseSelectedByTimePart(Integer studentId, String timePart) {
        return mapper.countStudentCourseSelectedByTimePart(studentId, timePart);
    }

    public List<TimetableItemVO> listStudentTimetable(Integer studentId) {
        return mapper.listStudentTimetable(studentId);
    }
}
