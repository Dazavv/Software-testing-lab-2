package org.example.math.log;

import org.example.util.Function;

public class Log implements Function {
    private final Ln ln;
    private final Integer base;

    public Log(Ln ln, Integer base) {
        this.ln = ln;
        this.base = base;
    }

    @Override
    public double calc(double x, double eps) {
        if (base <= 0 || base == 1.0 || Double.isNaN(base) || Double.isInfinite(base)) {
            throw new IllegalArgumentException("Invalid base: base must be > 0 and != 1");
        }
        if (x <= 0 || Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("Invalid x: x must be > 0");
        }

        return ln.calc(x, eps) / ln.calc(base, eps);
    }
}
