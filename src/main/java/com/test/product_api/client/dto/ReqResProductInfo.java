package com.test.product_api.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqResProductInfo {

    private int page;

    @JsonProperty("per_page")
    private int perPage;

    private int total;

    @JsonProperty("total_pages")
    private int totalPages;

    private List<ReqResData> data = Collections.emptyList();

    public ReqResProductInfo() {
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(final int page) {
        this.page = page;
    }

    public int getPerPage() {
        return this.perPage;
    }

    public void setPerPage(final int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(final int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(final int totalPages) {
        this.totalPages = totalPages;
    }

    public List<ReqResData> getData() {
        return this.data;
    }

    public void setData(final List<ReqResData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReqResProductInfo{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }
}
