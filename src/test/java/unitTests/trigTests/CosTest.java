package unitTests.trigTests;

import org.example.math.trig.Cos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CosTest {
    private static final double EPSILON = 1e-12;
    private static Cos cos;

    @BeforeAll
    public static void setUp() {
        cos = new Cos();
    }

    @Test
    public void testCosZero() {
        assertEquals(1.0, cos.calc(0.0, EPSILON), EPSILON);
    }

    @Test
    public void testCosPiOverTwo() {
        assertEquals(0.0, cos.calc(Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testCosPi() {
        assertEquals(-1.0, cos.calc(Math.PI, EPSILON), EPSILON);
    }

    @Test
    public void testCosNegative() {
        assertEquals(0.0, cos.calc(-Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testCosArbitraryValue() {
        double x = Math.PI / 3;
        assertEquals(Math.cos(x), cos.calc(x, EPSILON), EPSILON);
    }

    @Test
    public void testInvalidInputNaN() {
        assertThrows(IllegalArgumentException.class, () -> cos.calc(Double.NaN, EPSILON));
    }

    @Test
    public void testInvalidInputInfinity() {
        assertThrows(IllegalArgumentException.class, () -> cos.calc(Double.POSITIVE_INFINITY, EPSILON));
    }
}
