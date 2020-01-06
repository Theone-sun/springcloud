package com.dlsp.springcloud_server.service;

import com.dlsp.springcloud_server.mapper.Empmapper;
import com.dlsp.springcloud_server.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Empservice {
@Autowired
    private Empmapper empmapper;

public  Employee queryById(Integer id){
    return this.empmapper.selectByPrimaryKey(id);
}
}
