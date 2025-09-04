package org.example.math;

import org.example.math.log.*;
import org.example.math.trig.*;
import org.example.util.Function;

public class SystemFunction implements Function {
    public static final double eps = 1e-12;
    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Cot cot;
    private Sec sec;
    private Csc csc;
    private Ln ln;
    private Log log2;
    private Log log3;
    private Log log5;
    private Log log10;

    public SystemFunction(Ln ln, Log log2, Log log3, Log log5, Log log10) {
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }
    public SystemFunction(Sin sin, Cos cos, Tan tan, Cot cot, Sec sec, Csc csc) {
        this.sin = sin;
        this.cos = cos;
        this.tan = tan;
        this.cot = cot;
        this.sec = sec;
        this.csc = csc;
    }

    public SystemFunction() {
        this.sin = new Sin();
        this.cos = new Cos();
        this.tan = new Tan();
        this.cot = new Cot();
        this.sec = new Sec();
        this.csc = new Csc();
        this.ln = new Ln();
        this.log2 = new Log(ln, 2);
        this.log3 = new Log(ln, 3);
        this.log5 = new Log(ln, 5);
        this.log10 = new Log(ln, 10);
    }

    double result;
    @Override
    public double calc(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("Invalid input: division by zero or domain error.");
        }

        if (x <= 0 ) {
            result = (((Math.pow(Math.pow(((Math.pow(tan.calc(x, eps), 2) - csc.calc(x, eps)) - tan.calc(x, eps)), 2), 2)
                    / (cos.calc(x, eps) * cos.calc(x, eps))) * cot.calc(x, eps)) + (tan.calc(x, eps)
                    / Math.pow(((tan.calc(x, eps) + (sec.calc(x, eps) / (tan.calc(x, eps) * (sec.calc(x, eps) * cot.calc(x, eps)))))
                    + (sin.calc(x, eps) - ((sin.calc(x, eps) + csc.calc(x, eps)) - sin.calc(x, eps)))), 2)));
        } else if (x > 0) {
            result = Math.pow(((((log2.calc(x, eps) + log5.calc(x, eps)) / log3.calc(x, eps))
                    + (log10.calc(x, eps) * log10.calc(x, eps)))
                    * (ln.calc(x, eps) / log3.calc(x, eps))), 2);
        }

//    return Math.round(result * 1_000_000d) / 1_000_000d;
        return result;
    }
}
