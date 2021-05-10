package com.test.product_api.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.product_api.api.dto.PageInfo;
import com.test.product_api.api.dto.ProductInfo;
import com.test.product_api.client.dto.ReqResProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@Component
public class ReqresClient {

    private Logger logger = LoggerFactory.getLogger(ReqresClient.class);

    private static final String REQUEST_PARAMS = "?page=%d&per_page=%d";

    private RestTemplate restTemplate;

    private String url;



    @Autowired
    public ReqresClient(RestTemplate restTemplate, @Value("${reqrest.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public ReqResProductInfo getProductInfo(int page, int size) {
        ResponseEntity<String> response
                = restTemplate.getForEntity(getUrl(page, size), String.class);
        if (response.getStatusCode() == OK) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                ReqResProductInfo prodInfo = mapper.readValue(response.getBody(), ReqResProductInfo.class);
                logger.info("prodInfo: {}", prodInfo);
                return prodInfo;
            } catch (JsonProcessingException ex) {
                logger.error("exception while fetching product info", ex);
            }
        }
        return null;

    }

    private String getUrl(int page, int size){
        String newUrl = url+String.format(REQUEST_PARAMS,page, size);
        logger.info("url: {}", newUrl);
        return newUrl;
    }

}
