package com.student.system.service.student;

import com.student.system.manager.student.InfoManager;
import com.student.system.model.entity.StudentEntity;
import com.student.system.model.vo.request.StudentInfoFormVO;
import com.student.system.model.vo.response.ResultVO;
import com.student.system.service.BaseService;
import com.student.system.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

//学生信息服务
@Service
public class InfoService extends BaseService {
    private final InfoManager manager;

    public InfoService(InfoManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        return result(manager.getStudentInfoByStudentId(getUserId()));
    }

    //更新信息
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO studentInfoForm) {
    	//获取身份信息
        StudentEntity student = manager.getStudentById(getUserId());

        String password = studentInfoForm.getPassword();
        if (password == null || password.equals("")) {
            password = student.getPassword();
        } 

        //拷贝身份信息
        BeanUtils.copyProperties(studentInfoForm, student);
        student.setPassword(password);
        //更新身份信息
        manager.updateStudent(student);

        return result("更新成功");
    }
}
