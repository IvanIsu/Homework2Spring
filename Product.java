package com.isupov.mywork;


public class Product {
    private long id;
    private String name;
    private double cost;

    public Product(long id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }


    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
