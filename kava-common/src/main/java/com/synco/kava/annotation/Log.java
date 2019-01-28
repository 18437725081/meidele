package com.synco.kava.annotation;

import java.lang.annotation.*;

/**
 * @Author:wangshuai
 * @Date:2018/12/24
 */

@Inherited
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface Log {
    String value() default "";
}

