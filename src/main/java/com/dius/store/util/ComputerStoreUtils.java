package com.dius.store.util;


import com.dius.store.model.Product;
import com.dius.store.constants.ProductCode;
import com.dius.store.core.Catalogue;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.model.ProductDescription;
import com.dius.store.rules.BulkDiscountRule;
import com.dius.store.rules.BuyXGetDiscountRule;
import com.dius.store.rules.BuyXFreeBundleYRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ComputerStoreUtils {
    public Catalogue getCatalouge()
    {
        Catalogue catalogue = new Catalogue();
        catalogue.addNewProduct(new Product(new ProductDescription(ProductCode.ATV, "Apple TV"), new BigDecimal(109.50)));
        catalogue.addNewProduct(new Product(new ProductDescription(ProductCode.IPD, "Super iPad"), new BigDecimal(549.99)));
        catalogue.addNewProduct(new Product(new ProductDescription(ProductCode.VGA, "VGA adapter"), new BigDecimal(30.00)));
        catalogue.addNewProduct(new Product(new ProductDescription(ProductCode.MBP, "MacBook Pro"), new BigDecimal(1399.99)));
        return catalogue;
    }

    public Map<ProductCode, PricingRule> getPricingRules() {
        Map<ProductCode, PricingRule> pricingRules =  new HashMap<>();
        pricingRules.put(ProductCode.ATV, new BuyXGetDiscountRule(ProductCode.ATV));
        pricingRules.put(ProductCode.IPD, new BulkDiscountRule(ProductCode.IPD, 4, new BigDecimal(499.99)));
        pricingRules.put(ProductCode.VGA, new BuyXFreeBundleYRule(ProductCode.MBP, ProductCode.VGA));
        return pricingRules;
    }
}
