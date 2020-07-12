package com.dius.store.rules;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.Catalogue;
import com.dius.store.core.ShoppingCart;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class BulkDiscountRule implements PricingRule {
    private ProductCode productCode;
    private int discountQuantity;
    private BigDecimal discountPrice;


    public BulkDiscountRule(ProductCode productCode, int discountQuantity, BigDecimal discountPrice) {
        this.productCode = productCode;
        this.discountQuantity = discountQuantity;
        this.discountPrice = discountPrice;
    }

    @Override
    public void apply(ShoppingCart shoppingCart, Catalogue catalogue) {
        List<Product> products = shoppingCart.getProducts(productCode);
        if (products.size() > discountQuantity) {
            products.forEach(product -> product.setPrice(discountPrice));
        }
    }
}
