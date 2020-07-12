package com.dius.store.rules;

import com.dius.store.core.ShoppingCart;
import com.dius.store.core.interfaces.PricingRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(PowerMockRunner.class)
@PrepareForTest(BulkDiscountRule.class)
public class BulkDiscountRuleTest {

    @Test
    public void applyExecutionTest() {
        PricingRule pricingRule = mock(BulkDiscountRule.class);
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        doNothing().when(pricingRule).apply(any(ShoppingCart.class));
        pricingRule.apply(shoppingCart);
        verify(pricingRule).apply(shoppingCart);
    }
}
