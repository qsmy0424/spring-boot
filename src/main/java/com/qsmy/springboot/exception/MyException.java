package com.qsmy.springboot.exception;

public class MyException extends RuntimeException {
    public MyException() {
        super("异常了！！！！");
    }
}
