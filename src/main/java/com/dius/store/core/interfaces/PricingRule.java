package com.dius.store.core.interfaces;

import com.dius.store.core.Catalogue;
import com.dius.store.core.ShoppingCart;

public interface PricingRule {
    void apply(ShoppingCart shoppingCart, Catalogue catalogue);
}
