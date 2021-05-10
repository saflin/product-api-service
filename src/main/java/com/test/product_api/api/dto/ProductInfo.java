package com.test.product_api.api.dto;

import java.util.List;

public class ProductInfo {

    private PageInfo pageInfo;

    private List<Product> products;

    public ProductInfo(PageInfo pageInfo, List<Product> products) {
        this.pageInfo = pageInfo;
        this.products = products;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
