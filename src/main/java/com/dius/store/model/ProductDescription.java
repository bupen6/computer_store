package com.dius.store.model;


import com.dius.store.constants.ProductCode;

public class ProductDescription {
    private final ProductCode productCode;
    private final String productName;

    public ProductDescription(ProductCode productCode, String productName) {
        this.productCode = productCode;
        this.productName = productName;
    }

    public ProductCode getProductCode() {
        return productCode;
    }


    public String getProductName() {
        return productName;
    }
}
