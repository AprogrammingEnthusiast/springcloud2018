package com.wangj.cloud.controller;

import com.netflix.discovery.converters.Auto;
import com.wangj.cloud.entity.Dept;
import com.wangj.cloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer/")
public class DeptController_Consumer {
    /**
     * 使用feign的借口是编程，重写controller
     */
    @Autowired(required = false)
    private DeptClientService service;

    @RequestMapping(value = "/dept/add" ,method = RequestMethod.POST)
    public boolean add(Dept dept){
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}" ,method = RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id){
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list" ,method = RequestMethod.GET)
    public List<Dept> list(){
        return service.list();
    }

}
