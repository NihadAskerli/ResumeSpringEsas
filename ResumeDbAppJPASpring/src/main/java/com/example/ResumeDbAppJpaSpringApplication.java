package com.example;

import com.example.dao.impl.UserRepository;
import com.example.dao.impl.UserRepositoryCustom;
import com.example.entity.User;
import com.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);

    }

//    @Autowired
//    private UserServiceInter userService;
//
//    @Bean
//    public CommandLineRunner runner() {
//        CommandLineRunner clr = new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//
//                System.out.println(userService.getAll(null,null,null));
//
//
//            }
//        };
//        return clr;
//    }
}


