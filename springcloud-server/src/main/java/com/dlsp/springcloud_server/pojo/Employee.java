package com.dlsp.springcloud_server.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "employee")
@Data
public class Employee implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lastname;

    private  String email;

    private String gender;
}
