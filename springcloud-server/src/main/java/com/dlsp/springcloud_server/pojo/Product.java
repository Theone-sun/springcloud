package com.dlsp.springcloud_server.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Data
public class Product {

    @Id
    private Integer pid;
}
