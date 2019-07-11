package com.qsmy.springboot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author qsmy
 * @desctiption TODO
 * @date 2019-03-27 20:40
 */
@Component
public class QsmyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("QsmyApplicationRunner----");
        System.out.println(args);
    }
}
