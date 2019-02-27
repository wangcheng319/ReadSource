package com.dajiabao.readsource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangc on 2018/10/26
 * E-MAIL:274281610@QQ.COM
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
}
