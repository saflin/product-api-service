package com.test.product_api.service;

import com.test.product_api.api.dto.PageInfo;
import com.test.product_api.api.dto.Product;
import com.test.product_api.api.dto.ProductInfo;
import com.test.product_api.client.ReqresClient;
import com.test.product_api.client.dto.ReqResProductInfo;
import com.test.product_api.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ReqresClient reqresClient;

    @Autowired
    public ProductService(final ReqresClient reqresClient) {
        this.reqresClient = reqresClient;
    }

    public ProductInfo getProducts(int page, int size){
        ReqResProductInfo reqResProductInfo = reqresClient.getProductInfo(page, size);

        PageInfo pageInfo = new PageInfo(reqResProductInfo.getPage(),
                reqResProductInfo.getPerPage(), reqResProductInfo.getTotal(),
                reqResProductInfo.getTotalPages());
        List<Product> productList = Collections.emptyList();
        if(reqResProductInfo.getData() != null){
            productList = reqResProductInfo.getData()
                                            .stream()
                                            .map(DtoMapper::toProduct)
                                            .collect(Collectors.toList());
        }

        ProductInfo productInfo = new ProductInfo(pageInfo, productList);
        return productInfo;
    }
}
