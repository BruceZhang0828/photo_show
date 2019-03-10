package com.zhangran.photo_show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PhotoShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoShowApplication.class, args);
    }

}
