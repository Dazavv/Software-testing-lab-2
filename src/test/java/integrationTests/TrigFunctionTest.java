package integrationTests;

import org.example.math.SystemFunction;
import org.example.math.trig.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Тест тригонометрической функции")
public class TrigFunctionTest {
    static final double EPS = 1e-9;
    static final double relativeDelta = 1e-6;

    @ParameterizedTest(name = "x={0}, expected={7}")
    @CsvFileSource(resources = "/trig_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: sin, cos, tan, cot, sec, csc")
    public void testSystemWithAllMocks(double x,
                                       double sin,
                                       double cos,
                                       double tan,
                                       double cot,
                                       double sec,
                                       double csc,
                                       double expected) {
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);
        Tan tanMock = mock(Tan.class);
        Cot cotMock = mock(Cot.class);
        Sec secMock = mock(Sec.class);
        Csc cscMock = mock(Csc.class);

        when(sinMock.calc(x, EPS)).thenReturn(sin);
        when(cosMock.calc(x, EPS)).thenReturn(cos);
        when(tanMock.calc(x, EPS)).thenReturn(tan);
        when(cotMock.calc(x, EPS)).thenReturn(cot);
        when(secMock.calc(x, EPS)).thenReturn(sec);
        when(cscMock.calc(x, EPS)).thenReturn(csc);

        SystemFunction trigSystem = new SystemFunction(sinMock, cosMock, tanMock, cotMock, secMock, cscMock);
        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }


    @ParameterizedTest(name = "x={0}, expected={7}")
    @CsvFileSource(resources = "/trig_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: sin, cos, tan, cot, sec")
    public void testSystemWithCsc(double x,
                                  double sin,
                                  double cos,
                                  double tan,
                                  double cot,
                                  double sec,
                                  double csc,
                                  double expected) {

        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);
        Tan tanMock = mock(Tan.class);
        Cot cotMock = mock(Cot.class);
        Sec secMock = mock(Sec.class);

        Csc cscVal = new Csc(sinMock);

        when(sinMock.calc(x, EPS)).thenReturn(sin);
        when(cosMock.calc(x, EPS)).thenReturn(cos);
        when(tanMock.calc(x, EPS)).thenReturn(tan);
        when(cotMock.calc(x, EPS)).thenReturn(cot);
        when(secMock.calc(x, EPS)).thenReturn(sec);

        SystemFunction trigSystem = new SystemFunction(sinMock, cosMock, tanMock, cotMock, secMock, cscVal);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={7}")
    @CsvFileSource(resources = "/trig_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: sin, cos, tan, cot")
    public void testSystemWithCscSec(double x,
                                     double sin,
                                     double cos,
                                     double tan,
                                     double cot,
                                     double sec,
                                     double csc,
                                     double expected) {

        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);
        Tan tanMock = mock(Tan.class);
        Cot cotMock = mock(Cot.class);

        Csc cscVal = new Csc(sinMock);
        Sec secVal = new Sec(cosMock);

        when(sinMock.calc(x, EPS)).thenReturn(sin);
        when(cosMock.calc(x, EPS)).thenReturn(cos);
        when(tanMock.calc(x, EPS)).thenReturn(tan);
        when(cotMock.calc(x, EPS)).thenReturn(cot);

        SystemFunction trigSystem = new SystemFunction(sinMock, cosMock, tanMock, cotMock, secVal, cscVal);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={7}")
    @CsvFileSource(resources = "/trig_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: sin, cos, tan")
    public void testSystemWithCscSecCot(double x,
                                        double sin,
                                        double cos,
                                        double tan,
                                        double cot,
                                        double sec,
                                        double csc,
                                        double expected) {

        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);
        Tan tanMock = mock(Tan.class);

        Csc cscVal = new Csc(sinMock);
        Sec secVal = new Sec(cosMock);
        Cot cotVal = new Cot(sinMock, cosMock);

        when(sinMock.calc(x, EPS)).thenReturn(sin);
        when(cosMock.calc(x, EPS)).thenReturn(cos);
        when(tanMock.calc(x, EPS)).thenReturn(tan);

        SystemFunction trigSystem = new SystemFunction(sinMock, cosMock, tanMock, cotVal, secVal, cscVal);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={7}")
    @CsvFileSource(resources = "/trig_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: sin, cos")
    public void testSystemWithCscSecCotTan(double x,
                                           double sin,
                                           double cos,
                                           double tan,
                                           double cot,
                                           double sec,
                                           double csc,
                                           double expected) {

        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);

        Csc cscVal = new Csc(sinMock);
        Sec secVal = new Sec(cosMock);
        Cot cotVal = new Cot(sinMock, cosMock);
        Tan tanVal = new Tan(sinMock, cosMock);

        when(sinMock.calc(x, EPS)).thenReturn(sin);
        when(cosMock.calc(x, EPS)).thenReturn(cos);

        SystemFunction trigSystem = new SystemFunction(sinMock, cosMock, tanVal, cotVal, secVal, cscVal);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={7}")
    @CsvFileSource(resources = "/trig_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции с замоканным: sin")
    public void testSystemWithCscSecCotTanCos(double x,
                                           double sin,
                                           double cos,
                                           double tan,
                                           double cot,
                                           double sec,
                                           double csc,
                                           double expected) {

        Sin sinMock = mock(Sin.class);

        when(sinMock.calc(x, EPS)).thenReturn(sin);
        when(sinMock.calc(x + Math.PI / 2, EPS)).thenReturn(cos);

        Cos cosVal = new Cos(sinMock);
        Csc cscVal = new Csc(sinMock);
        Sec secVal = new Sec(cosVal);
        Cot cotVal = new Cot(sinMock, cosVal);
        Tan tanVal = new Tan(sinMock, cosVal);

        SystemFunction trigSystem = new SystemFunction(sinMock, cosVal, tanVal, cotVal, secVal, cscVal);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }

    @ParameterizedTest(name = "x={0}, expected={7}")
    @CsvFileSource(resources = "/trig_functions.csv", numLinesToSkip = 1)
    @DisplayName("Тест функции без моков")
    public void testSystemWithCscSecCotTanCosSin(double x,
                                              double sin,
                                              double cos,
                                              double tan,
                                              double cot,
                                              double sec,
                                              double csc,
                                              double expected) {
        Sin sinVal = new Sin();
        Cos cosVal = new Cos(sinVal);
        Csc cscVal = new Csc(sinVal);
        Sec secVal = new Sec(cosVal);
        Cot cotVal = new Cot(sinVal, cosVal);
        Tan tanVal = new Tan(sinVal, cosVal);

        SystemFunction trigSystem = new SystemFunction(sinVal, cosVal, tanVal, cotVal, secVal, cscVal);

        assertEquals(expected, trigSystem.calc(x, EPS), Math.abs(expected) * relativeDelta);
    }
}
