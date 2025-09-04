package org.example.math.trig;

import org.example.util.Function;

public class Csc implements Function {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public Csc() {
        sin = new Sin();
    }
    @Override
    public double calc(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("Illegal argument: " + x);
        }

        double val = sin.calc(x, eps);

        if (Math.abs(val) < eps) {
            throw new ArithmeticException("csc(x) is undefined at x = " + x + " (cos(x) is too close to zero)");
        }

        return 1.0 / val;
    }
}
