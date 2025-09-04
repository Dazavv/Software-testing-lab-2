package org.example;

import org.example.util.export.CsvExporter;
import org.example.math.SystemFunction;
import org.example.math.log.Ln;
import org.example.math.log.Log;
import org.example.math.trig.*;
import org.example.util.generator.FunctionDataGeneratorForTests;
import org.example.util.graph.CsvGraph;

import javax.swing.*;

public class Main {
    public static final double EPSILON = 1e-12;

    public static void main(String[] args) {
        FunctionDataGeneratorForTests.generate();

        CsvExporter.export(new Sin(), -10, 10, 0.01, EPSILON, "src/main/resources/sin.csv");
        CsvExporter.export(new Cos(), -10, 10, 0.01, EPSILON, "src/main/resources/cos.csv");
        CsvExporter.export(new Tan(), -10, 10, 0.01, EPSILON, "src/main/resources/tan.csv");
        CsvExporter.export(new Cot(), -10, 10, 0.01, EPSILON, "src/main/resources/cot.csv");
        CsvExporter.export(new Sec(), -10, 10, 0.01, EPSILON, "src/main/resources/sec.csv");
        CsvExporter.export(new Csc(), -10, 10, 0.01, EPSILON, "src/main/resources/csc.csv");

        CsvExporter.export(new Ln(), -10, 10, 0.01, EPSILON, "src/main/resources/ln.csv");
        CsvExporter.export(new Log(new Ln(), 2), -10, 10, 0.01, EPSILON, "src/main/resources/log2.csv");
        CsvExporter.export(new Log(new Ln(), 3), -10, 10, 0.01, EPSILON, "src/main/resources/log3.csv");
        CsvExporter.export(new Log(new Ln(), 5), -10, 10, 0.01, EPSILON, "src/main/resources/log5.csv");
        CsvExporter.export(new Log(new Ln(), 10), -10, 10, 0.01, EPSILON, "src/main/resources/log10.csv");

        CsvExporter.export(new SystemFunction(), -10, 10, 1, EPSILON, "src/main/resources/systemFunction.csv");
        CsvExporter.export(new SystemFunction(new Ln(), new Log(new Ln(), 2), new Log(new Ln(), 3), new Log(new Ln(), 5), new Log(new Ln(), 10)), 0.001, 20, 0.01, EPSILON, "src/main/resources/logFunction.csv");
        CsvExporter.export(new SystemFunction(new Sin(), new Cos(), new Tan(), new Cot(), new Sec(), new Csc()),
                -20, 0, 0.0001, EPSILON, "src/main/resources/trigFunction.csv");

        SwingUtilities.invokeLater(() -> {
            new CsvGraph("График sin(x)", "src/main/resources/sin.csv").setVisible(true);
            new CsvGraph("График cos(x)", "src/main/resources/cos.csv").setVisible(true);
            new CsvGraph("График ln(x)", "src/main/resources/ln.csv").setVisible(true);
            new CsvGraph("График log function", "src/main/resources/logFunction.csv").setVisible(true);
            new CsvGraph("График Trig function", "src/main/resources/trigFunction.csv").setVisible(true);
        });
    }
}