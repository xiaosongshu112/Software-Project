package com.student.system.model.bo;

import com.student.system.model.constant.UserType;
import com.student.system.model.entity.AdminEntity;
import com.student.system.model.entity.StudentEntity;
import com.student.system.model.entity.TeacherEntity;
import lombok.Data;

//确认身份并返回身份信息
@Data
public class AuthInfoBO {
    private Integer id;
    private String username;
    private String password;
    private Integer userType;
    private Integer permission = 0;

    public AuthInfoBO() {
    }

    private AuthInfoBO(Integer id, String username, String password, Integer userType) {
        this(id, username, password, userType, 0);
    }

    private AuthInfoBO(Integer id, String username, String password, Integer userType, Integer permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.permission = permission;
    }

    //返回学生身份信息
    public static AuthInfoBO fromStudent(StudentEntity entity) {
        if (entity == null) 
            return null;

        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.STUDENT);
    }
    
    //返回老师身份信息
    public static AuthInfoBO fromTeacher(TeacherEntity entity) {
        if (entity == null) 
            return null;

        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.TEACHER);
    }
    
    //返回管理员身份信息
    public static AuthInfoBO fromAdmin(AdminEntity entity) {
        if (entity == null) 
            return null;
        //权限为所有
        return new AuthInfoBO(entity.getId(), entity.getUsername(), entity.getPassword(), UserType.ADMIN, 255);
    }
}
