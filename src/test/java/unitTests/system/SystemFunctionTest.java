package unitTests.system;

import org.example.math.SystemFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тесты системы")
public class SystemFunctionTest {
    static final double EPS = 1e-9;
    double relativeDelta = 1e-6;

    @DisplayName("Тест выборки правильной функции системы: log")
    @Test
    public void testSystemFunctionBranch_Log() {
        double x = 2;
        double expected = 6.71190289181;

        SystemFunction system = new SystemFunction();
        assertEquals(expected, system.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @DisplayName("Тест выборки правильной функции системы: trig")
    @Test
    public void testSystemFunctionBranch_Trig() {
        double x = -2;
        double expected = 489.670282729;

        SystemFunction trigFunc = new SystemFunction();
        assertEquals(expected, trigFunc.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @DisplayName("Результат логарифмической функции: 0 < x < 1")
    @Test
    public void testSystemFunction_Log1() {
        double x1 = 0.1;
        double expected1 = 12.8866003041;

        double x2 = 0.5;
        double expected2 = 6.71190289181;

        double x3 = 0.999999;
        double expected3 = 6.20597198274;

        SystemFunction trigSystem = new SystemFunction();

        assertEquals(expected1, trigSystem.calc(x1, EPS), Math.abs(expected1) * relativeDelta);
        assertEquals(expected2, trigSystem.calc(x2, EPS), Math.abs(expected2) * relativeDelta);
        assertEquals(expected3, trigSystem.calc(x3, EPS), Math.abs(expected3) * relativeDelta);
    }

    @DisplayName("Результат логарифмической функции: x > 1")
    @Test
    public void testSystemFunction_Log2() {
        double x1 = 1.00000001;
        double expected1 = 6.20597198274;

        double x2 = 10;
        double expected2 = 12.8866003041;

        double x3 = 10000;
        double expected3 = 402.763775719;

        SystemFunction trigSystem = new SystemFunction();

        assertEquals(expected1, trigSystem.calc(x1, EPS), Math.abs(expected1) * relativeDelta);
        assertEquals(expected2, trigSystem.calc(x2, EPS), Math.abs(expected2) * relativeDelta);
        assertEquals(expected3, trigSystem.calc(x3, EPS), Math.abs(expected3) * relativeDelta);
    }

    @DisplayName("Логарифмическая функция: выброс исключения при x = 1")
    @Test
    public void testSystemFunction_LogNaN() {
        double x = 1;

        SystemFunction logSystem = new SystemFunction();
        double result = logSystem.calc(x, EPS);

        assertTrue(Double.isNaN(result));
    }

    @DisplayName("Выброс исключения при x = NaN")
    @Test
    public void testSystemFunction_NaN() {
        double x = Double.NaN;

        SystemFunction system = new SystemFunction();
        assertThrows(IllegalArgumentException.class, () -> system.calc(x, EPS));
    }

    @DisplayName("Выброс исключения при x = INFINITY")
    @Test
    public void testSystemFunction_INFINITY() {
        double x1 = Double.POSITIVE_INFINITY;
        double x2 = Double.POSITIVE_INFINITY;

        SystemFunction system = new SystemFunction();

        assertThrows(IllegalArgumentException.class, () -> system.calc(x1, EPS));
        assertThrows(IllegalArgumentException.class, () -> system.calc(x2, EPS));
    }

    @Test
    @DisplayName("Тригонометрической функции: выброс исключения если cos, sin = 0")
    public void testSystemFunction_TrigException() {
        double x1 = -Math.PI / 2;
        double x2 = -Math.PI;
        double x3 = -2 * Math.PI;
        double x4 = -10 * Math.PI;
        double x5 = 0;

        SystemFunction trigSystem = new SystemFunction();

        assertThrows(ArithmeticException.class, () -> trigSystem.calc(x1, EPS));
        assertThrows(ArithmeticException.class, () -> trigSystem.calc(x2, EPS));
        assertThrows(ArithmeticException.class, () -> trigSystem.calc(x3, EPS));
        assertThrows(ArithmeticException.class, () -> trigSystem.calc(x4, EPS));
        assertThrows(ArithmeticException.class, () -> trigSystem.calc(x5, EPS));
    }

    @Test
    @DisplayName("Результат тригонометрической функции")
    public void testSystemFunction_Trig() {
        double x1 = -Math.PI / 3;
        double expected1 = -2782.14454491;

        double x2 = -1;
        double expected2 = -1608.15876591;

        double x3 = -2;
        double expected3 = 489.670282729;

        double x4 = -10;
        double expected4 = -1.49770819557;

        double x5 = -2 * Math.PI / 3;
        double expected5 = 79.7437916404;

        SystemFunction trigSystem = new SystemFunction();

        assertEquals(expected1, trigSystem.calc(x1, EPS), Math.abs(expected1) * relativeDelta);
        assertEquals(expected2, trigSystem.calc(x2, EPS), Math.abs(expected2) * relativeDelta);
        assertEquals(expected3, trigSystem.calc(x3, EPS), Math.abs(expected3) * relativeDelta);
        assertEquals(expected4, trigSystem.calc(x4, EPS), Math.abs(expected4) * relativeDelta);
        assertEquals(expected5, trigSystem.calc(x5, EPS), Math.abs(expected5) * relativeDelta);
    }
}
