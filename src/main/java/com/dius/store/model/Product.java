package com.dius.store.model;

import java.math.BigDecimal;

public class Product {
    private ProductDescription productDescription;
    private BigDecimal price;

    public Product(ProductDescription product, BigDecimal price) {
        this.productDescription = product;
        this.price = price;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
