package org.example.math.log;

import org.example.util.Function;

public class Ln implements Function {
    @Override
    public double calc(double x, double eps) {
        if (Double.isNaN(x) || x <= 0 || Double.isInfinite(x)) {
            throw new ArithmeticException("Invalid input: ln(x) is only defined for x > 0");
        }
//        double currVal = (x - 1) / (x + 1);
//        double y = currVal;
//        double res = 0;
//        double previousResult = -1;
//        int step = 1;
//
//        while (Math.abs(res - previousResult) > eps) {
//            previousResult = res;
//            res += y / step;
//            y = y * currVal * currVal;
//            step += 2;
//        }
        double frac = (x - 1) / (x + 1);
        double fracSquared = frac * frac;
        double term = frac;
        double res = 0.0;

        int n = 0;
        while (Math.abs(term) > eps) {
            res += term / (2 * n + 1);
            term *= fracSquared;
            n++;
        }
        return 2 * res;
    }
}
