package com.dlsp.springcloud_consumer.controller;


import com.dlsp.springcloud_consumer.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("{id}")
    public Employee consume(@PathVariable Integer id) {
        String url = "http://localhost:8081/emp/"+id;
        Employee employee = restTemplate.getForObject(url, Employee.class);
        return employee;
    }
}
