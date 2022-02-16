package com.yzxie.study.eshopbiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {
        "com.yzxie.study.client",
        "com.yzxie.study.eshopbiz"
})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.yzxie.study.client"})
@ServletComponentScan
@MapperScan("com.yzxie.study.eshopbiz")
public class RepertoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepertoryApplication.class, args);
    }

}
