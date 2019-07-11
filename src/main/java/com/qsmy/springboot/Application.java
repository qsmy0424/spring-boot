package com.qsmy.springboot;

import com.qsmy.springboot.websocket.ChatRoomServerEndpoint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author qsmy
 */
@SpringBootApplication
@PropertySource(value = "classpath:config.properties")
@MapperScan("com.qsmy.springboot.mapper1")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        // 从命令行指定配置项的优先级最高，不过可以通过springApplication.setAddCommandLineProperties来禁用
       // SpringApplication springApplication = new SpringApplication();
       // springApplication.setAddCommandLineProperties(false);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}

