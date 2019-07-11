package com.qsmy.springboot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author qsmy
 * @desctiption TODO
 * @date 2019-03-27 20:42
 */
@Component
public class QsmyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("QsmyCommandLineRunner----");
        System.out.println(Arrays.asList(args));
    }
}
