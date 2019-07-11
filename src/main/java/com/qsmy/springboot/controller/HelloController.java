package com.qsmy.springboot.controller;

import com.qsmy.springboot.exception.MyException;
// import com.qsmy.starter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author qsmy
 */

@Controller
// @RestController
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    // @Autowired
    // private HelloService helloService;

    @ResponseBody
    @RequestMapping("/qsmy")
    public String qsmy() {
        throw new MyException();
        // return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map, HttpServletRequest request) {
        map.put("hello", "hello");
        request.getSession().setAttribute("user", "wwhm");
        return "success";
    }
    // @RequestMapping("/changeLanguage")
    // public String changeLanguage(HttpServletRequest request, HttpServletResponse response, String lange) {
    //     LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
    //     if ("zh_CN".equals(lange)) {
    //         localeResolver.setLocale(request, response, Locale.SIMPLIFIED_CHINESE);
    //     } else if ("en_US".equals(lange)) {
    //         localeResolver.setLocale(request, response, Locale.US);
    //     }
    //     return "success";
    // }

    @ResponseBody
    @RequestMapping("/query")
    public List<Map<String, Object>> query() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from qsmy");
        return maps;
    }

    // @ResponseBody
    // @RequestMapping("/hello")
    // public String getHello(String name) {
    //     String qsmy = helloService.sayHello("qsmy111");
    //     return qsmy;
    // }

    @RequestMapping("/qsmy_jsp")
    public String jsp(Map<String, Object> map) {
        map.put("name", "qsmy");
        map.put("date", new Date());
        return "qsmy";
    }
}
