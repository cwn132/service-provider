package com.springcloud.serviceprovider.serviceimpl;

import com.springcloud.serviceprovider.dao.Product;
import com.springcloud.serviceprovider.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> daoMap = new HashMap<>();

    //模拟数据库商品数据
    static {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Mate30pro");
        p1.setPrice(6999);
        p1.setStore(100);
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("苹果x1");
        p2.setPrice(5000);
        p2.setStore(12);
        Product p3 = new Product();
        Product p4 = new Product();

        daoMap.put(p1.getId(), p1);
        daoMap.put(p2.getId(), p2);
        daoMap.put(p3.getId(), p3);
        daoMap.put(p4.getId(), p4);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }
    @Override
    public Product findById(int id) {
        return daoMap.get(id);
    }
}