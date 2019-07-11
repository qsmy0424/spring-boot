package com.qsmy.springboot.config;

import com.qsmy.springboot.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qsmy
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(2);
        request.setAttribute("javax.servlet.error.status_code", 404);
        map.put("code", "自定义异常！");
        map.put("message", e.getMessage() + "1");
        request.setAttribute("ext", map);
        return "forward:/error";
    }
}
