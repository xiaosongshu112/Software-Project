package com.student.system.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.student.system.model.entity.StudentCourseEntity;
import com.student.system.model.vo.response.table.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseMapper extends BaseMapper<StudentCourseEntity> {

    Integer count(@Param("majorName")String majorName, @Param("courseName")String courseName, @Param("studentName")String studentName);

    IPage<StudentCourseItemVO> getPage(IPage<StudentCourseItemVO> page, @Param("majorName")String majorName, @Param("courseName")String courseName,@Param("studentName") String studentName);

    List<StudentCourseSelectedItemVO> listStudentCourseSelected(@Param("studentId")Integer studentId);

    Integer countStudentCourseSelectedByTimePart(@Param("studentId")Integer studentId,@Param("timePart") String timePart);

    List<TimetableItemVO> listStudentTimetable(Integer studentId);
}
