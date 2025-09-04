package org.example.util.export;

import org.example.util.Function;

import java.io.FileWriter;
import java.io.IOException;

public class CsvExporter {
    public static void export(Function func, double start, double end, double step, double eps, String filename){
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("X,Result\n");
            for (double x = start; x <= end; x += step) {
                double result;
                try {
                    result = func.calc(x, eps);
                } catch (IllegalArgumentException | ArithmeticException e) {
                    result = Double.NaN;
                }
                writer.write(x + "," + result + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи CSV: " + e.getMessage(), e);
        }
    }
}
