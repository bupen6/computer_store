package com.dius.store.core;


import com.dius.store.constants.ProductCode;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.exception.ProductNotFoundException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Checkout{
    private Map<ProductCode, PricingRule> pricingRules;
    private Catalogue catalogue;
    private ShoppingCart shoppingCart = new ShoppingCart();

    public Checkout(Map<ProductCode, PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public void scan(ProductCode productCode) throws ProductNotFoundException {
        shoppingCart.addProductToCart(catalogue.getNewProduct(productCode));
        PricingRule pricingRule = pricingRules.get(productCode);
        if (pricingRule != null) {
            pricingRule.apply(shoppingCart, catalogue);
        }
    }

    public BigDecimal total() {
        return shoppingCart.calculateTotalAmount().setScale(2, RoundingMode.HALF_EVEN);
    }
}
