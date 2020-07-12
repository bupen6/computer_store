package com.dius.store.rules;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.Catalogue;
import com.dius.store.core.ShoppingCart;
import com.dius.store.core.interfaces.PricingRule;
import com.dius.store.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class OneForOneBundleRule implements PricingRule {
    private ProductCode actualProductCode;
    private ProductCode bundledProductCode;

    public OneForOneBundleRule(ProductCode actualProduct, ProductCode bundledProduct) {
        this.actualProductCode = actualProduct;
        this.bundledProductCode = bundledProduct;
    }

    @Override
    public void apply(ShoppingCart shoppingCart, Catalogue catalogue) {
        List<Product>  products = shoppingCart.getProducts(actualProductCode);
        Product freeProduct = null;
        for (Product product : products) {
            try{
                freeProduct = catalogue.getNewProduct(bundledProductCode);
                freeProduct.setPrice(new BigDecimal(0));
            }
            catch(Exception e)
            {
                // Log message that Free Product is not available in the catalouge.
                // not doing because, using non-core dependencies are not encouraged in the task given.
            }
            shoppingCart.addProductToCart(freeProduct);
        }
    }
}
