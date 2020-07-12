package com.dius.store.core;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.utils.TestHelper;
import com.dius.store.exception.ProductNotFoundException;
import com.dius.store.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
@RunWith(PowerMockRunner.class)
@PrepareForTest(CatalogueTest.class)
public class CatalogueTest {
    
    @Test
    public void getNewProductTest() throws ProductNotFoundException {
        Catalogue catalogue = mock(Catalogue.class);
        Product testProduct = TestHelper.createTestProduct(ProductCode.MBP, "Mackbook Pro", new BigDecimal(60.00));
        when(catalogue.getNewProduct(any(ProductCode.class))).thenReturn(testProduct);
        Product product = catalogue.getNewProduct(ProductCode.MBP);
        verify(catalogue).getNewProduct(any(ProductCode.class));
        assertEquals(testProduct.getPrice(), product.getPrice());
        assertEquals(testProduct.getProductDescription().getProductCode(), product.getProductDescription().getProductCode());
        assertEquals(testProduct.getProductDescription().getProductName(), product.getProductDescription().getProductName());
    }
}
