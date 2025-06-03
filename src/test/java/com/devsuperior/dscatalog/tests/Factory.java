package com.devsuperior.dscatalog.tests;

import com.devsuperior.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {

    public static Product createProduct(){
        Product product = new Product();
        return product;
    }
}

