package com.student.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.system.dao.mapper.StudentMapper;
import com.student.system.model.entity.StudentEntity;
import com.student.system.model.vo.response.StudentInfoVO;
import com.student.system.model.vo.response.table.StudentItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final StudentMapper mapper; //数据库与数据库操作映射

    public StudentDAO(StudentMapper mapper) {
        this.mapper = mapper;
    }

    public StudentEntity getByNumber(String number) {
        LambdaQueryWrapper<StudentEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentEntity::getNumber, number);
        return mapper.selectOne(wrapper);
    }

    public int insert(StudentEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public StudentEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(StudentEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String majorName, String name) {
        return mapper.count(majorName, name);
    }

    public List<StudentItemVO> getPage(Integer index, String majorName, String name) {
        Page<StudentItemVO> page = new Page<>(index, PAGE_SIZE);
        
        return mapper.getPage(page, majorName, name).getRecords();
    }

    public Integer countByClassId(Integer id) {
        LambdaQueryWrapper<StudentEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentEntity::getMajorId, id);

        return mapper.selectCount(wrapper);
    }

    public List<StudentEntity> listName() {
        LambdaQueryWrapper<StudentEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(StudentEntity::getId, StudentEntity::getName);

        return mapper.selectList(wrapper);
    }

    public Integer getDepartmentIdById(Integer studentId) {
        return mapper.getDepartmentIdById(studentId);
    }

    public StudentInfoVO getStudentInfoById(Integer studentId) {
        return mapper.getStudentInfoById(studentId);
    }
}
