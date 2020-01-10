package com.dlsp.springcloud_server.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vid;
    private String vname;
    private String vaddress;
    private Date vdate;
}
