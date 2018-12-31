package com.wangj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 *    启动类
 *
 * @author wangj
 * @date 2018/8/9 11:02
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
/**
 * 开启hystrix熔断器
 */
@EnableCircuitBreaker
public class DeptProvider8001_Hystrix_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Hystrix_App.class,args);
    }

}
