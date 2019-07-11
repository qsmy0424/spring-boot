package com.qsmy.springboot.annotation;

import java.lang.annotation.*;

/**
 * 锁的注解
 *
 * @author qsmy
 * @date 2019-07-10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

    String key() default "";

    /**
     * 过期时间 集成redis需要用到
     * @return
     */
    int expire() default 5;
}
