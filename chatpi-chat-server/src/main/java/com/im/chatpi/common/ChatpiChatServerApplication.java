package com.im.chatpi.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.im.chatpi"})
@MapperScan({"com.im.chatpi.common.**.mapper"})
@ServletComponentScan
public class ChatpiChatServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ChatpiChatServerApplication.class, args);
    }
    
}
