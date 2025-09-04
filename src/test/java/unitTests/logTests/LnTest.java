package unitTests.logTests;

import org.example.math.log.Ln;
import org.example.util.Function;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {
    public static final double EPSILON = 1e-12;
    private static Function ln;

    @BeforeAll
    public static void setUp() {
        ln = new Ln();
    }

    @Test
    public void testLnOne() {
        assertEquals(0.0, ln.calc(1.0, EPSILON), EPSILON);
    }

    @Test
    public void testLnE() {
        assertEquals(1.0, ln.calc(Math.E, EPSILON), EPSILON);
    }

    @Test
    public void testLnGreaterThanOne() {
        assertEquals(Math.log(2.0), ln.calc(2.0, EPSILON), EPSILON);
    }

    @Test
    public void testLnSmallValue() {
        assertEquals(Math.log(0.5), ln.calc(0.5, EPSILON), EPSILON);
    }

    @Test
    public void testLnZero() {
        assertThrows(ArithmeticException.class, () -> ln.calc(0.0, EPSILON));
    }

    @Test
    public void testLnNegative() {
        assertThrows(ArithmeticException.class, () -> ln.calc(-1.0, EPSILON));
    }

    @Test
    public void testLnNaN() {
        assertThrows(ArithmeticException.class, () -> ln.calc(Double.NaN, EPSILON));
    }
}
