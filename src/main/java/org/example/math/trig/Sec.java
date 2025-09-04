package org.example.math.trig;

import org.example.util.Function;

public class Sec implements Function {
    private final Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public Sec() {
        cos = new Cos();
    }
    @Override
    public double calc(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("Illegal argument: " + x);
        }

        double val = cos.calc(x, eps);

        if (Math.abs(val) < eps) {
            throw new ArithmeticException("sec(x) is undefined at x = " + x + " (cos(x) is too close to zero)");
        }

        return 1.0 / val;
    }
}
