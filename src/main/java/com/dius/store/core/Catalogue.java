package com.dius.store.core;

import com.dius.store.constants.ProductCode;
import com.dius.store.model.Product;
import com.dius.store.exception.ProductNotFoundException;
import com.dius.store.model.ProductDescription;

import java.util.HashMap;
import java.util.Map;

public class Catalogue {
    private Map<ProductCode, Product> productCatalouge = new HashMap<>();

    public void addNewProduct(Product product) {
        productCatalouge.put(product.getProductDescription().getProductCode(), product);
    }

    public Product getNewProduct(ProductCode productCode) throws ProductNotFoundException {
        Product product = productCatalouge.get(productCode);
        if (product!=null) {
            return new Product(new ProductDescription(product.getProductDescription().getProductCode(), product.getProductDescription().getProductName()), product.getPrice());
        }
        else
            throw new ProductNotFoundException(productCode + " Not Found in the catalouge");
    }
}
