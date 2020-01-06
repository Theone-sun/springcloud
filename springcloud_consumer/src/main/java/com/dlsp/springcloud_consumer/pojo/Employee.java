package com.dlsp.springcloud_consumer.pojo;
import lombok.Data;
import java.io.Serializable;
@Data
public class Employee implements Serializable {

    private Integer id;

    private String lastname;

    private  String email;

    private String gender;
}
