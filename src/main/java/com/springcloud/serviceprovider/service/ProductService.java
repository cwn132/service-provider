package com.springcloud.serviceprovider.service;

import com.springcloud.serviceprovider.dao.Product;

import java.util.List;

public interface ProductService {

    //查找所有商品
    List<Product> listProduct();

    //根据商品ID查找商品
    Product findById(int id);
}