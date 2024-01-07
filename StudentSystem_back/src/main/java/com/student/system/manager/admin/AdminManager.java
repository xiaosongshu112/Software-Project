package com.student.system.manager.admin;

import com.student.system.dao.AdminDAO;
import com.student.system.manager.BaseManager;
import com.student.system.model.entity.AdminEntity;
import com.student.system.model.entity.StudentEntity;
import com.student.system.model.vo.response.IdNameVO;

import org.springframework.stereotype.Component;

import java.util.List;

//管理员管理组件
@Component
public class AdminManager extends BaseManager {
    private final AdminDAO adminDAO;

    public AdminManager(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public AdminEntity get(Integer id) {
        return adminDAO.get(id);
    }

    public int create(AdminEntity entity) {
        return adminDAO.insert(entity);
    }

    public int update(AdminEntity entity) {
        return adminDAO.update(entity);
    }

    public int delete(Integer id) {
        return adminDAO.delete(id);
    }

    public List<AdminEntity> list() {
    	
        return adminDAO.list();
    }
}
