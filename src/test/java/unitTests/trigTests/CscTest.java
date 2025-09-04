package unitTests.trigTests;

import org.example.math.trig.Csc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CscTest {
    public static final double EPSILON = 1e-12;
    private static Csc csc;

    @BeforeAll
    public static void setUp() {
        csc = new Csc();
    }

    @Test
    public void testCscPiOverTwo() {
        assertEquals(1.0, csc.calc(Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testCscNegativePiOverTwo() {
        assertEquals(-1.0, csc.calc(-Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testCscUndefined() {
        assertThrows(ArithmeticException.class, () -> csc.calc(0.0, EPSILON));
    }

    @Test
    public void testInvalidInputNaN() {
        assertThrows(IllegalArgumentException.class, () -> csc.calc(Double.NaN, EPSILON));
    }

    @Test
    public void testInvalidInputInfinity() {
        assertThrows(IllegalArgumentException.class, () -> csc.calc(Double.POSITIVE_INFINITY, EPSILON));
    }
}
