package org.example.math.trig;

import org.example.util.Function;
public class Cot implements Function {

    private final Sin sin;
    private final Cos cos;


    public Cot(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public Cot() {
        sin = new Sin();
        cos = new Cos();
    }

    @Override
    public double calc(double x, double eps) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("Invalid input: x must be a finite number");
        }

        double sinVal = sin.calc(x, eps);
        double cosVal = cos.calc(x, eps);

        if (Math.abs(sinVal) < eps) {
            throw new ArithmeticException("cot(x) is undefined at x = " + x + " (sin(x) is too close to zero)");
        }

        return cosVal / sinVal;
    }
}
