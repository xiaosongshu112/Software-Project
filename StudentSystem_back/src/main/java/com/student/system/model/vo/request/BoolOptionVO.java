package com.student.system.model.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BoolOptionVO {
    @NotNull
    public Boolean option;
}
