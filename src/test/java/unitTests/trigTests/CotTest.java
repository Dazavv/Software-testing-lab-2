package unitTests.trigTests;

import org.example.math.trig.Cot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CotTest {
    public static final double EPSILON = 1e-12;
    private static Cot cot;

    @BeforeAll
    public static void setUp() {
        cot = new Cot();
    }

    @Test
    public void testCotPiOverFour() {
        assertEquals(1.0, cot.calc(Math.PI / 4, EPSILON), EPSILON);
    }

    @Test
    public void testCotPiOverSix() {
        assertEquals(Math.cos(Math.PI / 6) / Math.sin(Math.PI / 6), cot.calc(Math.PI / 6, EPSILON), EPSILON);
    }

    @Test
    public void testCotUndefined() {
        assertThrows(ArithmeticException.class, () -> cot.calc(0.0, EPSILON));

    }

    @Test
    public void testInvalidInputNaN() {
        assertThrows(IllegalArgumentException.class, () -> cot.calc(Double.NaN, EPSILON));
    }
}
