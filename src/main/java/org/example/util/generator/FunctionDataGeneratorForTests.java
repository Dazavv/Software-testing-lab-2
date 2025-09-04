package org.example.util.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class FunctionDataGeneratorForTests {

    public static void generate() {
        double start = -2.0;
        double end = 2.5;
        double step = 0.08;

        try (FileWriter trigWriter = new FileWriter("src/test/resources/trig_functions.csv");
             FileWriter logWriter = new FileWriter("src/test/resources/log_functions.csv");
             FileWriter systemWriter = new FileWriter("src/test/resources/system_functions.csv")) {

            trigWriter.write("x,sin,cos,tan,cot,sec,csc,expected\n");

            logWriter.write("x,ln,log2,log3,log5,log10,ln10,ln5,ln3,ln2,expected\n");

            for (double x = start; x <= end + 1e-9; x += step) {

                double sin = Math.sin(x);
                double cos = Math.cos(x);

                if (Math.abs(sin) < 1e-9 || Math.abs(cos) < 1e-9) {
                    continue;
                }

                double tan = sin / cos;
                double cot = cos / sin;
                double sec = 1.0 / cos;
                double csc = 1.0 / sin;

                double trigExpected;
                if (x <= 0) {
                    double temp1 = Math.pow(Math.pow((Math.pow(tan, 2) - csc) - tan, 2), 2) / (cos * cos);
                    double temp2 = tan / Math.pow((tan + (sec / (tan * (sec * cot))) + (sin - ((sin + csc) - sin))), 2);
                    trigExpected = temp1 * cot + temp2;

                    trigWriter.write((String.format(Locale.US, "%.12f,%.12f,%.12f,%.12f,%.12f,%.12f,%.12f,%.12f\n",
                            x,
                            sin,
                            cos,
                            tan,
                            cot,
                            sec,
                            csc,
                            trigExpected)));
                }


                if (x > 0) {
                    double lnVal = Math.log(x);
                    double log2 = lnVal / Math.log(2);
                    double log3 = lnVal / Math.log(3);
                    double log5 = lnVal / Math.log(5);
                    double log10 = Math.log10(x);
                    double ln10 = Math.log(10);
                    double ln5 = Math.log(5);
                    double ln3 = Math.log(3);
                    double ln2 = Math.log(2);
                    double logExpected = Math.pow(((log2 + log5)/log3 + Math.pow(log10,2)) * (lnVal / log3), 2);

                    logWriter.write(String.format(Locale.US,"%.12f,%.12f,%.12f,%.12f,%.12f,%.12f,%.12f,%.12f,%.12f,%.12f,%.12f\n",
                            x, lnVal, log2, log3, log5, log10, ln10, ln5, ln3, ln2, logExpected));
                }
            }

            System.out.println("Файлы созданы!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
