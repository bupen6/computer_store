package com.dius.store.core;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.interfaces.ComputerStore;
import com.dius.store.core.interfaces.PricingRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


@RunWith(PowerMockRunner.class)
@PrepareForTest(ComputerStoreImpl.class)
public class ComputerStoreImplTest{

    @Test
    public void getPricingRulesExecutionTestSuccess() {
        ComputerStore computerStore = mock(ComputerStoreImpl.class);
        Map<ProductCode, PricingRule> pricingRules = mock(Map.class);
        computerStore.getPricingRules();
        when(computerStore.getPricingRules()).thenReturn(pricingRules);
        verify(computerStore).getPricingRules();
    }

    @Test
    public void checkoutExecutionTestSuccess() {
        ComputerStore computerStore = mock(ComputerStoreImpl.class);
        Checkout checkout = mock(Checkout.class);
        Map<ProductCode, PricingRule> pricingRules = mock(Map.class);
        when(computerStore.checkout(pricingRules)).thenReturn(checkout);
        computerStore.checkout(pricingRules);
        verify(computerStore).checkout(pricingRules);
    }

}
