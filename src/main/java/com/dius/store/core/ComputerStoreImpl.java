package com.dius.store.core;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.util.ComputerStoreUtils;
import com.dius.store.core.interfaces.ComputerStore;

import java.util.Map;

public class ComputerStoreImpl implements ComputerStore {

    private Catalogue catalogue;
    private Map<ProductCode, PricingRule> pricingRules;
    public ComputerStoreImpl() {
        ComputerStoreUtils computerStoreUtils = new ComputerStoreUtils();
        catalogue = computerStoreUtils.getCatalouge();
        pricingRules = computerStoreUtils.getPricingRules();
    }


    public Catalogue getCatalogue() {
        return catalogue;
    }

    @Override
    public Map<ProductCode, PricingRule> getPricingRules() {
        return pricingRules;
    }

    @Override
    public Checkout checkout(Map<ProductCode, PricingRule>  pricingRules) {
        return new Checkout(pricingRules);
    }
}
