package com.student.system.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.student.system.model.bo.CourseItemBO;
import com.student.system.model.bo.StudentCourseSelectItemBO;
import com.student.system.model.entity.CourseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper extends BaseMapper<CourseEntity> {
    Integer count(@Param("departmentName")String departmentName, @Param("teacherName")String teacherName, @Param("name")String name);

    IPage<CourseItemBO> getPage(IPage<CourseItemBO> page, @Param("departmentName")String departmentName, @Param("teacherName")String teacherName, @Param("name")String name);

    Integer getDepartmentIdById(Integer courseId);
}
