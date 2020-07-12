package com.dius.store.core;

import com.dius.store.constants.ProductCode;
import com.dius.store.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ShoppingCart.class)
public class ShoppingCartTest {
    List<Product> shoppingCartList = new ArrayList<>();


    @Test
    public void addProductToCartExecutionTestSuccess() {
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        Product product = mock(Product.class);
        doNothing().when(shoppingCart).addProductToCart(any(Product.class));
        shoppingCart.addProductToCart(product);
        verify(shoppingCart).addProductToCart(product);
    }

    @Test
    public void getProductsExecutionTestSuccess() {
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        List<Product> products = mock(List.class);
        when(shoppingCart.getProducts(any(ProductCode.class))).thenReturn(products);
        shoppingCart.getProducts(ProductCode.MBP);
        verify(shoppingCart).getProducts(ProductCode.MBP);
    }

    @Test
    public void removeProductFromCartExecutionTestSuccess() {
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        doNothing().when(shoppingCart).removeProductFromCart(any(ProductCode.class));
        shoppingCart.removeProductFromCart(ProductCode.MBP);
        verify(shoppingCart).removeProductFromCart(ProductCode.MBP);
    }

    @Test
    public void calculateTotalAmountExecutionTestSuccess() {
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        when(shoppingCart.calculateTotalAmount()).thenReturn(new BigDecimal(60.00));
        shoppingCart.calculateTotalAmount();
        verify(shoppingCart).calculateTotalAmount();
    }
}
