package com.dius.store.rules;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.ShoppingCart;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.model.Product;
import com.dius.store.core.Catalogue;

import java.math.BigDecimal;
import java.util.List;

public class BuyForXPayForYRule implements PricingRule {
    private ProductCode productCode;

    public BuyForXPayForYRule(ProductCode productCode) {
        this.productCode = productCode;
    }

    @Override
    public void apply(ShoppingCart shoppingCart, Catalogue catalogue) {
        List<Product> productList = shoppingCart.getProducts(productCode);
        for (int i=0; i<productList.size(); i++) {
            if (i+1 == 3) {
                Product product = productList.get(i);
                product.setPrice(new BigDecimal(0));
            }
        }
    }
}
