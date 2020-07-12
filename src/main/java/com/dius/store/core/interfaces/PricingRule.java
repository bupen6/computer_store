package com.dius.store.core.interfaces;

import com.dius.store.core.ShoppingCart;

public interface PricingRule {
    void apply(ShoppingCart shoppingCart);
}
