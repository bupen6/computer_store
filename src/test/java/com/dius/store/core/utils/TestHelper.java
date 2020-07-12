package com.dius.store.core.utils;

import com.dius.store.constants.ProductCode;
import com.dius.store.model.Product;
import com.dius.store.model.ProductDescription;

import java.math.BigDecimal;

public class TestHelper {
    
    public static Product createTestProduct(ProductCode productCode, String productName, BigDecimal price) {
        return new Product(new ProductDescription(productCode, productName), price);
    }
}
