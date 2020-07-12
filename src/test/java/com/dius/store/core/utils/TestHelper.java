package com.dius.store.core.utils;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.model.Product;
import com.dius.store.model.ProductDescription;
import com.dius.store.rules.BulkDiscountRule;
import com.dius.store.rules.BuyForXPayForYRule;
import com.dius.store.rules.OneForOneBundleRule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHelper {
    
    public static Product createTestProduct(ProductCode productCode, String productName, BigDecimal price) {
        return new Product(new ProductDescription(productCode, productName), price);
    }

    public static Map<ProductCode, PricingRule> createTestPricingRules() {
        Map<ProductCode, PricingRule> pricingRules =  new HashMap<>();
        pricingRules.put(ProductCode.ATV, new BuyForXPayForYRule(ProductCode.ATV));
        pricingRules.put(ProductCode.IPD, new BulkDiscountRule(ProductCode.IPD, 4, new BigDecimal(499.99)));
        pricingRules.put(ProductCode.MBP, new OneForOneBundleRule(ProductCode.MBP, ProductCode.VGA));
        return pricingRules;
    }
}
