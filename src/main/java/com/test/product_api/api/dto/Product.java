package com.test.product_api.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private int id;

    private String name;

    private int year;

    private String color;

    @JsonProperty("pantone_value")
    private String pantoneValue;

    public Product() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getPantoneValue() {
        return this.pantoneValue;
    }

    public void setPantoneValue(final String pantoneValue) {
        this.pantoneValue = pantoneValue;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", pantoneValue='" + pantoneValue + '\'' +
                '}';
    }
}
