package com.synco.kava.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * 权限注解
 * @Author:wangshuai
 * @Date:2019/1/25
 */

@Inherited
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Documented
public @interface Auth {
    boolean value() default false;
}

