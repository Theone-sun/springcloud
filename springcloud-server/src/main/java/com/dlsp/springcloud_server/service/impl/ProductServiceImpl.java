package com.dlsp.springcloud_server.service.impl;

import com.dlsp.springcloud_server.mapper.ProductMapper;
import com.dlsp.springcloud_server.pojo.Product;
import com.dlsp.springcloud_server.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired(required = false)
    private ProductMapper productMapper;
    @Override
    public List<Product> selProductsByUid(Integer uid) {
        return productMapper.getProductsByUid(uid);
    }
}
