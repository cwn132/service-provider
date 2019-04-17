package com.springcloud.serviceprovider.controller;

import com.springcloud.serviceprovider.dao.Product;
import com.springcloud.serviceprovider.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestIOrderController {

    @Autowired
    private ProductService productService;

    //集群情况下，用于订单服务查看到底调用的是哪个商品微服务节点
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/saveIorder",method = RequestMethod.GET)
    public Object saveIorder(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId){

        Product product = productService.findById(productId);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName( result.getName() + " data from port="+port );
        return result;
    }
}
