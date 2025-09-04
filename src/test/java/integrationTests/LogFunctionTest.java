package integrationTests;

import org.example.math.SystemFunction;
import org.example.math.log.Ln;
import org.example.math.log.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Тест логарифмической функции")
public class LogFunctionTest {
    static final double EPS = 1e-9;
    double relativeDelta = 1e-6;

    @ParameterizedTest(name = "x={0}, expected={10}")
    @CsvFileSource(resources = "/log_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: log10, log5, log3, log2, ln")
    public void testSystemWithAllMocks(double x,
                                       double ln,
                                       double log2,
                                       double log3,
                                       double log5,
                                       double log10,
                                       double ln10,
                                       double ln5,
                                       double ln3,
                                       double ln2,
                                       double expected) {
        Ln lnMock = mock(Ln.class);
        Log log2Mock = mock(Log.class);
        Log log3Mock = mock(Log.class);
        Log log5Mock = mock(Log.class);
        Log log10Mock = mock(Log.class);

        when(lnMock.calc(x, EPS)).thenReturn(ln);
        when(log2Mock.calc(x, EPS)).thenReturn(log2);
        when(log3Mock.calc(x, EPS)).thenReturn(log3);
        when(log5Mock.calc(x, EPS)).thenReturn(log5);
        when(log10Mock.calc(x, EPS)).thenReturn(log10);

        SystemFunction trigSystem = new SystemFunction(lnMock, log2Mock, log3Mock, log5Mock, log10Mock);
        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }


    @ParameterizedTest(name = "x={0}, expected={10}")
    @CsvFileSource(resources = "/log_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: log5, log3, log2, ln")
    public void testSystemWithLog10(double x,
                                    double ln,
                                    double log2,
                                    double log3,
                                    double log5,
                                    double log10,
                                    double ln10,
                                    double ln5,
                                    double ln3,
                                    double ln2,
                                    double expected) {

        Ln lnMock = mock(Ln.class);
        Log log2Mock = mock(Log.class);
        Log log3Mock = mock(Log.class);
        Log log5Mock = mock(Log.class);

        when(lnMock.calc(x, EPS)).thenReturn(ln);
        when(lnMock.calc(10, EPS)).thenReturn(ln10);
        when(log2Mock.calc(x, EPS)).thenReturn(log2);
        when(log3Mock.calc(x, EPS)).thenReturn(log3);
        when(log5Mock.calc(x, EPS)).thenReturn(log5);

        Log log10Val = new Log(lnMock, 10);

        SystemFunction trigSystem = new SystemFunction(lnMock, log2Mock, log3Mock, log5Mock, log10Val);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={10}")
    @CsvFileSource(resources = "/log_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: log3, log2, ln")
    public void testSystemWithLog10Log5(double x,
                                    double ln,
                                    double log2,
                                    double log3,
                                    double log5,
                                    double log10,
                                    double ln10,
                                    double ln5,
                                    double ln3,
                                    double ln2,
                                    double expected) {

        Ln lnMock = mock(Ln.class);
        Log log2Mock = mock(Log.class);
        Log log3Mock = mock(Log.class);

        when(lnMock.calc(x, EPS)).thenReturn(ln);
        when(lnMock.calc(10, EPS)).thenReturn(ln10);
        when(lnMock.calc(5, EPS)).thenReturn(ln5);
        when(log2Mock.calc(x, EPS)).thenReturn(log2);
        when(log3Mock.calc(x, EPS)).thenReturn(log3);

        Log log10Val = new Log(lnMock, 10);
        Log log5Val = new Log(lnMock, 5);

        SystemFunction trigSystem = new SystemFunction(lnMock, log2Mock, log3Mock, log5Val, log10Val);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={10}")
    @CsvFileSource(resources = "/log_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: log2, ln")
    public void testSystemWithLog10Log5Log3(double x,
                                        double ln,
                                        double log2,
                                        double log3,
                                        double log5,
                                        double log10,
                                        double ln10,
                                        double ln5,
                                        double ln3,
                                        double ln2,
                                        double expected) {

        Ln lnMock = mock(Ln.class);
        Log log2Mock = mock(Log.class);

        when(lnMock.calc(x, EPS)).thenReturn(ln);
        when(lnMock.calc(10, EPS)).thenReturn(ln10);
        when(lnMock.calc(5, EPS)).thenReturn(ln5);
        when(lnMock.calc(3, EPS)).thenReturn(ln3);
        when(log2Mock.calc(x, EPS)).thenReturn(log2);

        Log log10Val = new Log(lnMock, 10);
        Log log5Val = new Log(lnMock, 5);
        Log log3Val = new Log(lnMock, 3);

        SystemFunction trigSystem = new SystemFunction(lnMock, log2Mock, log3Val, log5Val, log10Val);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={10}")
    @CsvFileSource(resources = "/log_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: ln")
    public void testSystemWithLog10Log5Log3Log2(double x,
                                            double ln,
                                            double log2,
                                            double log3,
                                            double log5,
                                            double log10,
                                            double ln10,
                                            double ln5,
                                            double ln3,
                                            double ln2,
                                            double expected) {

        Ln lnMock = mock(Ln.class);

        when(lnMock.calc(x, EPS)).thenReturn(ln);
        when(lnMock.calc(10, EPS)).thenReturn(ln10);
        when(lnMock.calc(5, EPS)).thenReturn(ln5);
        when(lnMock.calc(3, EPS)).thenReturn(ln3);
        when(lnMock.calc(2, EPS)).thenReturn(ln2);

        Log log10Val = new Log(lnMock, 10);
        Log log5Val = new Log(lnMock, 5);
        Log log3Val = new Log(lnMock, 3);
        Log log2Val = new Log(lnMock, 2);

        SystemFunction trigSystem = new SystemFunction(lnMock, log2Val, log3Val, log5Val, log10Val);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={10}")
    @CsvFileSource(resources = "/log_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции без моков")
    public void testSystemWithLog10Log5Log3Log2Ln(double x,
                                                double ln,
                                                double log2,
                                                double log3,
                                                double log5,
                                                double log10,
                                                double ln10,
                                                double ln5,
                                                double ln3,
                                                double ln2,
                                                double expected) {
        Ln lnVal = new Ln();
        Log log10Val = new Log(lnVal, 10);
        Log log5Val = new Log(lnVal, 5);
        Log log3Val = new Log(lnVal, 3);
        Log log2Val = new Log(lnVal, 2);

        SystemFunction trigSystem = new SystemFunction(lnVal, log2Val, log3Val, log5Val, log10Val);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }
}