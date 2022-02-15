package com.yzxie.study.eshopbiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.yzxie.study.client"})
public class EshopBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopBizApplication.class, args);
    }

}
