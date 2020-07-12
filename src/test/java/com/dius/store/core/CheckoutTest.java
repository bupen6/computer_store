package com.dius.store.core;


import com.dius.store.constants.ProductCode;
import com.dius.store.exception.ProductNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Checkout.class)
public class CheckoutTest {

    @Test
    public void scanTestExecutionSuccess() throws ProductNotFoundException {
        Checkout checkout = mock(Checkout.class);
        doNothing().when(checkout).scan(ProductCode.MBP);
        checkout.scan(ProductCode.MBP);
        verify(checkout).scan(ProductCode.MBP);
    }

    @Test
    public void totalTestExecutionSuccess() throws ProductNotFoundException {
        Checkout checkout = mock(Checkout.class);
        when(checkout.total()).thenReturn(new BigDecimal(60.00));
        checkout.total();
        verify(checkout).total();
    }

    @Test
    public void totalTestSuccess() throws ProductNotFoundException {
        Checkout checkout = mock(Checkout.class);
        when(checkout.total()).thenReturn(new BigDecimal(60.00));
        BigDecimal total = checkout.total();
        assertEquals(60.00, total.doubleValue());
    }
}
