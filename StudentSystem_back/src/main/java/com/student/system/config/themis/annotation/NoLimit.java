package com.student.system.config.themis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解适用范围
@Target({ElementType.TYPE, ElementType.METHOD})
//注解生命周期
@Retention(RetentionPolicy.RUNTIME)
public @interface NoLimit {
}