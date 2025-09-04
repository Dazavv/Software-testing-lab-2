package unitTests.trigTests;

import org.example.math.trig.Sec;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecTest {
    public static final double EPSILON = 1e-12;
    private static Sec sec;

    @BeforeAll
    public static void setUp() {
        sec = new Sec();
    }

    @Test
    public void testSecZero() {
        assertEquals(1.0, sec.calc(0.0, EPSILON), EPSILON);
    }

    @Test
    public void testSecPi() {
        assertEquals(-1.0, sec.calc(Math.PI, EPSILON), EPSILON);
    }

    @Test
    public void testSecUndefined() {
        assertThrows(ArithmeticException.class, () -> sec.calc(Math.PI / 2, EPSILON));
    }

    @Test
    public void testInvalidInputNaN() {
        assertThrows(IllegalArgumentException.class, () -> sec.calc(Double.NaN, EPSILON));

    }

    @Test
    public void testInvalidInputInfinity() {
        assertThrows(IllegalArgumentException.class, () -> sec.calc(Double.POSITIVE_INFINITY, EPSILON));
    }


}
