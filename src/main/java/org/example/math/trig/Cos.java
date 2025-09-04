package org.example.math.trig;

import org.example.util.Function;

public class Cos implements Function {
    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public Cos() {
        sin = new Sin();
    }
    @Override
    public double calc(double x, double eps) {
        return sin.calc(x + Math.PI / 2, eps);
    }
}
