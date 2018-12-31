package com.wangj.cloud.controller;

import com.wangj.cloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer/")
public class DeptController_Consumer {

    /**
     * private static final String REST_URL_PREFIX = "http://localhost:8001";
     * 使用Ribbon之后将不再使用之前的通过固定地址调用生产者，而是直接使用服务名称调用，正真实现客户端的负载均衡（LB）
     */
    private static final String REST_URL_PREFIX = "http://CLOUD-PROVIDER-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/dept/add" ,method = RequestMethod.POST)
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/dept/get/{id}" ,method = RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get"+id,Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/dept/list" ,method = RequestMethod.GET)
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @RequestMapping(value = "/dept/discovery" ,method = RequestMethod.GET)
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }
}
