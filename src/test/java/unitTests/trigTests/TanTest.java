package unitTests.trigTests;

import org.example.math.trig.Tan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TanTest {
    public static final double EPSILON = 1e-12;
    private static Tan tan;

    @BeforeAll
    public static void setUp() {
        tan = new Tan();
    }


    @Test
    public void testTanZero() {
        assertEquals(0.0, tan.calc(0.0, EPSILON), EPSILON);
    }

    @Test
    public void testTanPiOverFour() {
        assertEquals(1.0, tan.calc(Math.PI / 4, EPSILON), EPSILON);
    }

    @Test
    public void testTanPiOverSix() {
        assertEquals(Math.tan(Math.PI / 6), tan.calc(Math.PI / 6, EPSILON), EPSILON);
    }

    @Test
    public void testTanUndefined() {
        assertThrows(ArithmeticException.class, () -> tan.calc(Math.PI / 2, EPSILON));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> tan.calc(Double.POSITIVE_INFINITY, EPSILON));
    }
}
