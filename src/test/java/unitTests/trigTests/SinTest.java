package unitTests.trigTests;

import org.example.math.trig.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinTest {
    public static final double EPSILON = 1e-12;

    private static Sin sin;

    @BeforeAll
    public static void setUp() {
        sin = new Sin();
    }
    @Test
    public void testSinZero() {
        assertEquals(0.0, sin.calc(0.0, EPSILON), EPSILON);
    }

    @Test
    public void testSinPiOverSix() {
        assertEquals(0.5, sin.calc(Math.PI / 6, EPSILON), EPSILON);
    }

    @Test
    public void testSinPiOverFour() {
        assertEquals(Math.sqrt(2) / 2, sin.calc(Math.PI / 4, EPSILON), EPSILON);
    }

    @Test
    public void testSinPiOverTwo() {
        assertEquals(1.0, sin.calc(Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testSinPi() {
        assertEquals(0.0, sin.calc(Math.PI, EPSILON), EPSILON);
    }

    @Test
    public void testSinThreePiOverTwo() {
        assertEquals(-1.0, sin.calc(3 * Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testSinTwoPi() {
        assertEquals(0.0, sin.calc(2 * Math.PI, EPSILON), EPSILON);
    }

    @Test
    public void testNegativeInput() {
        assertEquals(-0.5, sin.calc(-Math.PI / 6, EPSILON), EPSILON);
        assertEquals(-1.0, sin.calc(-Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testPeriodicity() {
        double x = Math.PI / 3;
        double expected = 0.866025403784;
        assertEquals(expected, sin.calc(x + 2 * Math.PI, EPSILON), EPSILON);
        assertEquals(expected, sin.calc(x - 2 * Math.PI, EPSILON), EPSILON);
    }

    @Test
    public void testSymmetry() {
        double x = Math.PI / 4;
        assertEquals(-sin.calc(-x, EPSILON), sin.calc(x, EPSILON), EPSILON);
    }

    @Test
    public void testInvalidInputNaN() {
        assertThrows(IllegalArgumentException.class, () -> sin.calc(Double.NaN, EPSILON));
    }

    @Test
    public void testInvalidInputInfinity() {
        assertThrows(IllegalArgumentException.class, () -> sin.calc(Double.POSITIVE_INFINITY, EPSILON));
    }
}
