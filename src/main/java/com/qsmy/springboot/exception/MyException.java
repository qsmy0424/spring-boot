package com.qsmy.springboot.exception;

/**
 * @author qsmy
 */
public class MyException extends RuntimeException {
    public MyException() {
        super("异常了！！！！");
    }
}
