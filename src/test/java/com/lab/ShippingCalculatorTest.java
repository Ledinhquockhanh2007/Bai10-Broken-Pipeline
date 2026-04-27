package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShippingCalculatorTest {
    ShippingCalculator calc = new ShippingCalculator();

    @Test
    void testStandard() {
        assertEquals(15000.0, calc.calculate(5, "STANDARD"));
    }

    @Test
    void testExpress() {
        assertEquals(45000.0, calc.calculate(5, "EXPRESS"));
    }

    @Test
    void testInvalidWeight() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.calculate(-1, "STANDARD"));
    }

    @Test
    void testFreeShipping() {
        // Cố tình kỳ vọng cân nặng 0kg thì phí là 0 đồng (Sẽ gây lỗi vì logic không cho phép <= 0)
        assertEquals(0.0, calc.calculate(0, "STANDARD"));
    }
}