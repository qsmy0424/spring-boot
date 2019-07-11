package com.qsmy.springboot.controller;

import com.qsmy.springboot.annotation.LocalLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qsmy
 * @date 2019-07-10
 */
@RestController
@RequestMapping("/books")
public class BookController {

    // @LocalLock(key = "book:arg[0]");意味着会将arg[0]替换成第一个参数值，生成后的新key将被缓存起来；
    @LocalLock(key = "book:arg[0]")
    @GetMapping
    public String query(@RequestParam String token) {
        return "success - " + token;
    }
}
