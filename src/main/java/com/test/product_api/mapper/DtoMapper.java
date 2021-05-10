package com.test.product_api.mapper;

import com.test.product_api.api.dto.Product;
import com.test.product_api.client.dto.ReqResData;

public class DtoMapper {

    public static Product toProduct(ReqResData reqResData){
        Product product = new Product();
        product.setId(reqResData.getId());
        product.setName(reqResData.getName());
        product.setColor(reqResData.getColor());
        product.setYear(reqResData.getYear());
        product.setPantoneValue(reqResData.getPantoneValue());
        return product;
    }
}
