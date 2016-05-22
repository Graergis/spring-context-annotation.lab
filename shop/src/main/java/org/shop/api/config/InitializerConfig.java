package org.shop.api.config;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.common.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InitializerConfig {

    @Autowired
    private ProductService productService;

    @Autowired
    public UserService userService;

    @Autowired
    public SellerService sellerService;

    @Bean
    public DataInitializer dataInitializer() {return new DataInitializer();}

    @Bean
    public ProductInitializer productInitializer() {return new ProductInitializer(productService, products());}

    @Bean
    public SellerInitializer sellerInitializer() {return new SellerInitializer(sellerService, sellerNames());}

    @Bean
    public UserInitializer userInitializer() {return new UserInitializer(userService);}

    public Map<Long, String> sellerNames() {
        Map<Long, String> result = new HashMap<>();
        result.put(1l, "sdas");
        result.put(2l, "asd212");
        return result;
    }

    public Map<String, String> products() {
        Map<String, String> product = new HashMap<>();
        product.put(Products.SAMSUNG_GALAXY_TAB, "10.1-Inch, 16GB, Wi-Fi");
        product.put(Products.KINDLE_FIRE, "Wi-Fi, Full Color 7, Multi-Touch Display");
        product.put(Products.KINDLE_TOUCH, "Wi-Fi, 6 E Ink Display");
        product.put(Products.SAMSUNG_GALAXY_ACE, "Samsung S5830L Galaxy Ace");
        return product;
    }
}
