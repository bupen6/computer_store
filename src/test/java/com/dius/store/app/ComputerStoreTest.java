package com.dius.store.app;

import com.dius.store.constants.ProductCode;
import com.dius.store.core.Checkout;
import com.dius.store.core.interfaces.ComputerStore;
import com.dius.store.core.ComputerStoreImpl;
import com.dius.store.exception.ProductNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;


/**
 *  Run This test to see the result of the app using the given catalouge
 */
public class ComputerStoreTest {
    private ComputerStore computerStore;
    private Checkout checkout;

    private final List<String> APPLE_TV_TEST_DATA = Arrays.asList("ATV", "ATV");
    private final List<String> APPLE_TV_TEST_DATA_DISCOUNT = Arrays.asList("ATV", "ATV", "ATV");
    private final List<String> IPAD_TEST_DATA = Arrays.asList("IPD", "IPD", "IPD", "IPD");
    private final List<String> IPAD_TEST_DATA_DISCOUNT = Arrays.asList("IPD", "IPD", "IPD", "IPD", "IPD");
    private final List<String> MACBOOK_PRO_TEST_DATA = Arrays.asList("MBP");
    private final List<String> MACBOOK_PRO_TEST_DATA_2 = Arrays.asList("MBP", "MBP", "MBP", "MBP", "MBP", "MBP");
    private final List<String> EXAMPLE_SCENARIO1 = Arrays.asList("ATV", "ATV", "ATV", "VGA");
    private final List<String> EXAMPLE_SCENARIO2 = Arrays.asList("ATV", "IPD", "IPD", "ATV", "IPD", "IPD", "IPD");
    private final List<String> EXAMPLE_SCENARIO3 = Arrays.asList("MBP", "VGA", "IPD");


    @Before
    public void setUp() {
        computerStore = new ComputerStoreImpl();
        checkout = computerStore.checkout(computerStore.getPricingRules());
        checkout.setCatalogue(computerStore.getCatalogue());
    }

    @Test
    public void appleTvRuleTest() throws ProductNotFoundException {
        for (String testProductCode : APPLE_TV_TEST_DATA) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(219.00, total.doubleValue());
        System.out.println("SKUs Scanned: " + APPLE_TV_TEST_DATA.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

    @Test
    public void appleTvRuleTestDiscount() throws ProductNotFoundException {
        for (String testProductCode : APPLE_TV_TEST_DATA_DISCOUNT) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(219.00, total.doubleValue());
        System.out.println("SKUs Scanned: " + APPLE_TV_TEST_DATA_DISCOUNT.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

    @Test
    public void iPadRuleTest() throws ProductNotFoundException {
        for (String testProductCode : IPAD_TEST_DATA) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(2199.96, total.doubleValue());
        System.out.println("SKUs Scanned: " + IPAD_TEST_DATA.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

    @Test
    public void iPadRuleTestDiscount() throws ProductNotFoundException {
        for (String testProductCode : IPAD_TEST_DATA_DISCOUNT) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(2499.95, total.doubleValue());
        System.out.println("SKUs Scanned: " + IPAD_TEST_DATA_DISCOUNT.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

    @Test
    public void mapbookProRuleTest() throws ProductNotFoundException {
        for (String testProductCode : MACBOOK_PRO_TEST_DATA) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(1399.99, total.doubleValue());
        System.out.println("SKUs Scanned: " + MACBOOK_PRO_TEST_DATA.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

    @Test
    public void mapbookProRuleTest2() throws ProductNotFoundException {
        for (String testProductCode : MACBOOK_PRO_TEST_DATA_2) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(8399.94, total.doubleValue());
        System.out.println("SKUs Scanned: " + MACBOOK_PRO_TEST_DATA_2.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

    @Test
    public void exampleScenario1() throws ProductNotFoundException {
        for (String testProductCode : EXAMPLE_SCENARIO1) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(249.00, total.doubleValue());
        System.out.println("SKUs Scanned: " + EXAMPLE_SCENARIO1.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

    @Test
    public void exampleScenario2() throws ProductNotFoundException {
        for (String testProductCode : EXAMPLE_SCENARIO2) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(2718.95, total.doubleValue());
        System.out.println("SKUs Scanned: " + EXAMPLE_SCENARIO2.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

    @Test
    public void exampleScenario3() throws ProductNotFoundException {
        for (String testProductCode : EXAMPLE_SCENARIO3) {
            checkout.scan(ProductCode.valueOf(testProductCode));
        }
        BigDecimal total = checkout.total();
        assertEquals(1949.98, total.doubleValue());
        System.out.println("SKUs Scanned: " + EXAMPLE_SCENARIO3.stream().collect(Collectors.joining(",")) + " Total expected: " + total);
    }

}
