package com.dlsp.springcloud_consumer.service;

import com.dlsp.springcloud_consumer.pojo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    public Employee consume(@PathVariable Integer id){
        // 获取服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 获取实例
        ServiceInstance instance = instances.get(0);
        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/1";
        Employee employee=restTemplate.getForObject(url,Employee.class);

        return employee;
    }

}
