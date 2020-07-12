package com.dius.store.core;

import com.dius.store.constants.ProductCode;
import com.dius.store.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    List<Product> shoppingCartList = new ArrayList<>();

    public void addProductToCart(Product product) {
        shoppingCartList.add(product);
    }


    public List<Product> getProducts(ProductCode productCode) {
        return shoppingCartList.stream().filter(product -> product.getProductDescription().getProductCode().equals(productCode)).collect(Collectors.toList());
    }

    public void removeProductFromCart(ProductCode productCode) {
        this.shoppingCartList.removeIf(product -> product.getProductDescription().getProductCode().equals(productCode));
    }

    public BigDecimal calculateTotalAmount() {
        return shoppingCartList.stream().map(product -> product.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
