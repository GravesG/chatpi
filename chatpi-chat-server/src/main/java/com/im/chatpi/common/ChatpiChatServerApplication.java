package com.im.chatpi.common;

import org.jasypt.encryption.StringEncryptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = {"com.im.chatpi"})
@MapperScan({"com.im.chatpi.common.**.mapper"})
public class ChatpiChatServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ChatpiChatServerApplication.class, args);
    }
    
}
