package com.wangj.cloud.controller;

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
    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "dept/add" ,method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "dept/get/{id}" ,method = RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "dept/list" ,method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    @RequestMapping(value = "dept/discovery" ,method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("*********"+ list);
        List<ServiceInstance> srvList = client.getInstances("CLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance:srvList) {
            System.out.println(instance.getServiceId() + "/t" +instance.getHost() + "/t" +
                    instance.getPort() + "/t" +instance.getUri() + "/t" );
        }
        return this.client;
    }
}
