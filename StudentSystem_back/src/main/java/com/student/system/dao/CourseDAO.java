package com.student.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.system.dao.mapper.CourseMapper;
import com.student.system.model.bo.CourseItemBO;
import com.student.system.model.bo.StudentCourseSelectItemBO;
import com.student.system.model.entity.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final CourseMapper mapper;

    public CourseDAO(CourseMapper mapper) {
        this.mapper = mapper;
    }

    public int insert(CourseEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public CourseEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(CourseEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String departmentName, String teacherName, String name) {
        return mapper.count(departmentName, teacherName, name);
    }

    public List<CourseItemBO> getPage(Integer index, String departmentName, String teacherName, String name) {
        Page<CourseItemBO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, departmentName, teacherName, name).getRecords();
    }

    public Integer countByTeacherId(Integer teacherId) {
        LambdaQueryWrapper<CourseEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CourseEntity::getTeacherId, teacherId);

        return mapper.selectCount(wrapper);
    }

    public List<CourseEntity> listName() {
        LambdaQueryWrapper<CourseEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(CourseEntity::getId, CourseEntity::getName);

        return mapper.selectList(wrapper);
    }
    
    public Integer getDepartmentIdById(Integer courseId) {
        return mapper.getDepartmentIdById(courseId);
    }
}
