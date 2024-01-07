package com.student.system.controller.admin;

import com.student.system.config.themis.annotation.Admin;
import com.student.system.controller.BaseController;
import com.student.system.model.entity.MajorEntity;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.admin.MajorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//专业管理
@Admin
@RequestMapping("/admin/major")
@RestController
public class MajorController extends BaseController {
    private final MajorService service;

    public MajorController(MajorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated MajorEntity entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated MajorEntity entity) {
        return service.update(entity);
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String departmentName, String name) {
        ResultVO pageCount = service.getPageCount(departmentName, name);
        System.out.println(pageCount);
        return service.getPageCount(departmentName, name);
    }

    @RequestMapping("/page")
    public ResultVO getPage(String departmentName, String name) {
        return service.getPage(1, departmentName, name);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String departmentName, String name) {
        return service.getPage(index, departmentName, name);
    }

    @Admin
    @RequestMapping("/names")
    public ResultVO listName() {
        return service.listName();
    }
}
