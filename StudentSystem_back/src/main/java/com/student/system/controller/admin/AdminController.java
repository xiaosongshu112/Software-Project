package com.student.system.controller.admin;

import com.student.system.config.themis.annotation.Admin;
import com.student.system.controller.BaseController;
import com.student.system.model.entity.AdminEntity;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.admin.AdminService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin
@RequestMapping("/admin/admin")
@RestController
public class AdminController extends BaseController {
    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated AdminEntity entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated AdminEntity entity) {
        return service.update(entity);
    }

    @GetMapping()
    public ResultVO list() {
        return service.list();
    }
}
