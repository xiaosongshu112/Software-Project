package com.student.system.manager.admin;

import com.student.system.dao.DepartmentDAO;
import com.student.system.dao.MajorDAO;
import com.student.system.manager.BaseManager;
import com.student.system.model.entity.DepartmentEntity;
import com.student.system.model.entity.MajorEntity;
import com.student.system.model.vo.response.IdNameVO;
import com.student.system.model.vo.response.table.MajorItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//专业管理组件
@Component
public class MajorManager extends BaseManager {
    private final MajorDAO majorDAO;
    private final DepartmentDAO departmentDAO;

    public MajorManager(MajorDAO majorDAO, DepartmentDAO departmentDAO) {
        this.majorDAO = majorDAO;
        this.departmentDAO = departmentDAO;
    }

    public Integer getPageCount(String departmentName, String name) {
        int count = majorDAO.count(departmentName, name);
        return calcPageCount(count, MajorDAO.PAGE_SIZE);
    }

    public List<MajorItemVO> getPage(Integer index, String departmentName, String name) {
        return majorDAO.getPage(index, departmentName, name);
    }

    public MajorEntity get(Integer id) {
        return majorDAO.get(id);
    }

    public int create(MajorEntity entity) {
        return majorDAO.insert(entity);
    }

    public int update(MajorEntity entity) {
        return majorDAO.update(entity);
    }

    public int delete(Integer id) {
        return majorDAO.delete(id);
    }

    public DepartmentEntity getDepartmentById(Integer id) {
        return departmentDAO.get(id);
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<MajorEntity> entityList = majorDAO.listName();
        for (MajorEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
