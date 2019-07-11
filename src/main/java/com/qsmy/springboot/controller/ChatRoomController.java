package com.qsmy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qsmy
 * @date 2019-07-09
 */
@Controller
@RequestMapping("chat")
public class ChatRoomController {

    @RequestMapping("/chat")
    public String index() {
        return "chat";
    }
}
