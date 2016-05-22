package org.shop;

import org.shop.api.ProductService;
import org.shop.data.Product;

import java.util.Map;

/**
 * The Product Initializer util class.
 */
public final class ProductInitializer {
    
    /** The product service. */
    private ProductService productService;

    private final Map<String, String> products;

    /**
     * Instantiates a new product initializer.
     *
     * @param productService the product service
     * @param products
     */
    public ProductInitializer(ProductService productService, Map<String, String> products) {
        super();
        this.productService = productService;
        this.products = products;
    }
    
    /**
     * Inits the products.
     */
    public void initProducts() {
        for (Map.Entry<String, String> entry : products.entrySet()){
            Product product = new Product();
            product.setName(entry.getKey());
            product.setDescription(entry.getValue());
            productService.createProduct(product);
        }
    }
}
