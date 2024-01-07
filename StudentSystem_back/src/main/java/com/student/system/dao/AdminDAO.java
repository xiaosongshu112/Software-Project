package com.student.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.student.system.dao.mapper.AdminMapper;
import com.student.system.model.entity.AdminEntity;
import com.student.system.model.entity.StudentEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDAO extends BaseDAO {
    private final AdminMapper mapper;

    public AdminDAO(AdminMapper mapper) {
        this.mapper = mapper;
    }

    public AdminEntity getByUsername(String username) {
        LambdaQueryWrapper<AdminEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdminEntity::getUsername, username);
        return mapper.selectOne(wrapper);
    }

    public int insert(AdminEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public AdminEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(AdminEntity entity) {
        return mapper.updateById(entity);
    }

    public List<AdminEntity> list() {
    	LambdaQueryWrapper<AdminEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(AdminEntity::getId, AdminEntity::getUsername);
        return mapper.selectList(wrapper);
    }
}
