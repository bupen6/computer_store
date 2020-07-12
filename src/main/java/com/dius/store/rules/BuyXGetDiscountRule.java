package com.dius.store.rules;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.ShoppingCart;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class BuyXGetDiscountRule implements PricingRule {
    private ProductCode productCode;
    private int discountQuantity;

    public BuyXGetDiscountRule(ProductCode productCode, int discountQuantity) {
        this.productCode = productCode;
        this.discountQuantity = discountQuantity;
    }

    @Override
    public void apply(ShoppingCart shoppingCart) {
        List<Product> productList = shoppingCart.getProducts(productCode);
        for (int i=0; i<productList.size(); i++) {
            if (i+1 == discountQuantity) {
                Product product = productList.get(i);
                product.setPrice(new BigDecimal(0));
            }
        }
    }
}
