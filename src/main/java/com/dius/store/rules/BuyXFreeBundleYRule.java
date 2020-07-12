package com.dius.store.rules;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.ShoppingCart;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class BuyXFreeBundleYRule implements PricingRule {
    private ProductCode actualProductCode;
    private ProductCode bundledProductCode;

    public BuyXFreeBundleYRule(ProductCode actualProduct, ProductCode bundledProduct) {
        this.actualProductCode = actualProduct;
        this.bundledProductCode = bundledProduct;
    }

    @Override
    public void apply(ShoppingCart shoppingCart) {
        List<Product>  products = shoppingCart.getProducts(actualProductCode);
        List<Product>  existingBundleProducts = shoppingCart.getProducts(bundledProductCode);
        for (int i = 0; i < existingBundleProducts.size(); i++) {
            if (i < products.size() ) {
                Product product = existingBundleProducts.get(i);
                product.setPrice(new BigDecimal(0));
            }
        }
    }
}
