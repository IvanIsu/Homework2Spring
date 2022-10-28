package com.isupov.mywork;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class ProductRepository {
    private ArrayList<Product> productsHolder;


    public ProductRepository(){
        this.productsHolder = new ArrayList<>();
    }
    @PostConstruct
    public void init(){
        System.out.println("Вызван init метод");
        productsHolder.add(new Product(1L, "Glue", 10.0));
        productsHolder.add(new Product(2L, "Lemon Tree", 25.0));
        productsHolder.add(new Product(3L, "Table", 22.0));
        productsHolder.add(new Product(4L, "Apple", 5.0));
        productsHolder.add(new Product(5L, "Orange", 6.0));
    }

    public ArrayList<Product> getProductsHolder() {
        return productsHolder;
    }
    public Optional<Product> getProduct(long id) {
        for (Product o : productsHolder) {
            if(o.getId() == id){
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }

}
