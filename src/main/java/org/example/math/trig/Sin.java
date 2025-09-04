package org.example.math.trig;

import org.example.util.Function;

import static java.lang.Math.PI;

public class Sin implements Function {

    @Override
    public double calc(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("Illegal argument: " + x);
        }

        x = x % (PI * 2);

        if (Double.compare(x, 0D) == 0) {
            return 0.0;
        }
        if (Double.compare(x, PI / 2) == 0) {
            return 1.0;
        }
        if (Double.compare(x, -PI / 2) == 0) {
            return -1.0;
        }

        double term = x;
        double res = 0;
        int n = 1;

        while (Math.abs(term) > eps) {
            res += term;
            term *= -1 * x * x / ((2 * n) * (2 * n + 1));
            n++;
        }
        return res;
    }
}
