package com.kaykay.dianping.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 3:11 下午 2021/12/29.
 * @Modified By:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminPermission {

    String produceType() default "text/html";
}
