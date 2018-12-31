package com.wangj.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangj.cloud.service.DeptService;
import com.wangj.cloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 一旦调用服务方法失败并抛出异常，会自动调用@HystrixCommand标注好的fallbackMethod调用类中置顶的方法
     */
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if (null == dept) {
            new RuntimeException("通过id:" + id + "没有查到此部门");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("该ID:"+id+"没有找到对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in Mysql");
    }
}
