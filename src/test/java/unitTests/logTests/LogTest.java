package unitTests.logTests;

import org.example.math.log.Ln;
import org.example.math.log.Log;
import org.example.util.Function;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogTest {
    private static final double EPSILON = 1e-10;
    private static Function ln;

    @BeforeAll
    public static void setUp() {
        ln = new Ln();
    }

    @Test
    public void testLogBase2() {
        Function log2 = new Log((Ln) ln, 2);
        assertEquals(1.0, log2.calc(2.0, EPSILON), EPSILON);
        assertEquals(3.0, log2.calc(8.0, EPSILON), EPSILON);
    }

    @Test
    public void testLogBase3() {
        Function log3 = new Log((Ln) ln, 3);
        assertEquals(1.0, log3.calc(3.0, EPSILON), EPSILON);
        assertEquals(2.0, log3.calc(9.0, EPSILON), EPSILON);
    }

    @Test
    public void testLogBase5() {
        Function log5 = new Log((Ln) ln, 5);
        assertEquals(1.0, log5.calc(5.0, EPSILON), EPSILON);
        assertEquals(2.0, log5.calc(25.0, EPSILON), EPSILON);
    }

    @Test
    public void testLogBase10() {
        Function log10 = new Log((Ln) ln, 10);
        assertEquals(1.0, log10.calc(10.0, EPSILON), EPSILON);
        assertEquals(2.0, log10.calc(100.0, EPSILON), EPSILON);
        assertEquals(0.0, log10.calc(1.0, EPSILON), EPSILON);
    }

    @Test
    void testInvalidBaseZero() {
        assertThrows(IllegalArgumentException.class, () -> new Log((Ln) ln, 0).calc(10.0, EPSILON));
    }

    @Test
    void testInvalidBaseOne() {
        assertThrows(IllegalArgumentException.class, () -> new Log((Ln) ln, 1).calc(10.0, EPSILON));
    }

    @Test
    void testInvalidXZero() {
        Function log2 = new Log((Ln) ln, 2);
        assertThrows(IllegalArgumentException.class, () -> log2.calc(0.0, EPSILON));
    }

    @Test
    void testInvalidXNegative() {
        Function log2 = new Log((Ln) ln, 2);
        assertThrows(IllegalArgumentException.class, () -> log2.calc(-1.0, EPSILON));
    }
}
