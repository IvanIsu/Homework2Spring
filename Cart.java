package com.isupov.mywork;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {
    private ArrayList<Product> products;



    public Cart(){
        products = new ArrayList<>();
    }


    public void addToCart(Product product){
        products.add(product);
    }
    public boolean deleteFromCart(int id){
        for (Product o: products) {
            if(id == o.getId()){
                products.remove(o);
                return true;
            }
        }
        return false;
    }
    public void showCart(){
        for (Product o: products) {
            System.out.println(o);
        }
    }

}
