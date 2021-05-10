package com.test.product_api.api.controller;

import com.test.product_api.api.dto.ProductInfo;
import com.test.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductInfo getProducts(@RequestParam(value = "page", defaultValue="1") int page,
                                   @RequestParam(value = "size", defaultValue ="5" ) int size,
                                   UriComponentsBuilder uriBuilder, HttpServletResponse response){

        return productService.getProducts(page, size);

    }
}
