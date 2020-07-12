package com.dius.store.core.interfaces;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.Catalogue;
import com.dius.store.core.Checkout;

import java.util.Map;

public interface ComputerStore {

    Catalogue getCatalogue();
    Map<ProductCode, PricingRule> getPricingRules();
    Checkout checkout(Map<ProductCode, PricingRule> pricingRules);
}
