package com.student.system.service.admin;

import com.student.system.manager.admin.MajorManager;
import com.student.system.model.entity.MajorEntity;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class MajorService extends BaseService {
    private final MajorManager manager;

    public MajorService(MajorManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(String departmentName, String name) {
        return result(manager.getPageCount(departmentName, name));
    }

    public ResultVO getPage(Integer index, String departmentName, String name) {
        return result(manager.getPage(index, departmentName, name));
    }

    public ResultVO get(Integer id) {
        MajorEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("专业Id: " + id + "不存在!");
        }

        return result(entity);
    }

    public ResultVO update(MajorEntity entity) {
        if (manager.get(entity.getId()) == null) {
            return failedResult("专业Id: " + entity.getId() + "不存在!");
        }
        if (manager.getDepartmentById(entity.getDepartmentId()) == null) {
            return failedResult("所属系Id: " + entity.getDepartmentId() + "不存在!");
        }

        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        if (manager.get(id) == null) {
            return failedResult("专业Id: " + id + "不存在!");
        }

        manager.delete(id);
        return result("删除成功");
    }

    public ResultVO create(MajorEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("专业Id: " + entity.getId() + "已存在!");
        }
        if (manager.getDepartmentById(entity.getDepartmentId()) == null) {
            return failedResult("所属系Id: " + entity.getDepartmentId() + "不存在!");
        }

        manager.create(entity);
        return result("添加成功");
    }

    public ResultVO listName() {
        return result(manager.listName());
    }
}
