package com.student.system.service.admin;

import com.student.system.manager.admin.AdminManager;
import com.student.system.model.entity.AdminEntity;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseService {
    private final AdminManager manager;

    public AdminService(AdminManager manager) {
        this.manager = manager;
    }

    public ResultVO get(Integer id) {
        AdminEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("管理员Id: " + id + "不存在!");
        }

        entity.setPassword("");

        return result(entity);
    }

    public ResultVO update(AdminEntity entity) {
        AdminEntity originEntity = manager.get(entity.getId());
        if (originEntity == null) {
            return failedResult("管理员Id: " + entity.getId() + "不存在!");
        }

        if (entity.getPassword().equals("")) {
            entity.setPassword(originEntity.getPassword());
        } else {
            entity.setPassword(entity.getPassword());
        }
        
        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        if (manager.get(id) == null) {
            return failedResult("管理员Id: " + id + "不存在!");
        }

        manager.delete(id);
        return result("删除成功");
    }

    public ResultVO create(AdminEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("管理员Id: " + entity.getId() + "已存在!");
        }

        manager.create(entity);
        return result("添加成功");
    }

    public ResultVO list() {
        return result(manager.list());
    }
}
