package com.wangj.cloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    /**
     * Sprng cloud ribbon是基于Netflix Ribbon实现的一套客户端  负载均衡（LB）工具
     */
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /*@Bean
    public IRule myRule(){
        //return new RandomRule();
        return new RetryRule();
    }*/
}
