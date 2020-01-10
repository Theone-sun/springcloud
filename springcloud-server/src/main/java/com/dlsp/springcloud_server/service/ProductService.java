package com.dlsp.springcloud_server.service;

import com.dlsp.springcloud_server.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> selProductsByUid(Integer uid);
}
