package com.dlsp.springcloud_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 开启EurekaClient功能
public class SpringcloudServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServerApplication.class, args);
    }

}
