package com.dlsp.springcloud_server.controller;

import com.dlsp.springcloud_server.pojo.Employee;
import com.dlsp.springcloud_server.service.Empservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class ServerController {
    @Autowired
    private Empservice empservice;

    @GetMapping("/{id}")
    public Employee selById(@PathVariable("id") Integer id){
        System.out.println(id);
        System.out.println(empservice.queryById(id));
        return empservice.queryById(id);

    }


}
