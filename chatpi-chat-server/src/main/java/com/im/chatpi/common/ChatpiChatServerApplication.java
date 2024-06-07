package com.im.chatpi.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.im.chatpi"})
@MapperScan({"com.im.chatpi.common.**.mapper"})
public class ChatpiChatServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ChatpiChatServerApplication.class, args);
    }
    
}
