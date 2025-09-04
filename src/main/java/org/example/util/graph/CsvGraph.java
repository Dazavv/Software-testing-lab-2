package org.example.util.graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvGraph extends JFrame {

    public CsvGraph(String title, String csvFile) {
        super(title);

        // создаём одну серию
        XYSeries series = new XYSeries(title);

        // Читаем CSV
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = br.readLine(); // пропускаем заголовок
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);

                // отсекаем "стены" (слишком большие значения)
                if (Math.abs(y) > 1e3 || Double.isInfinite(y) || Double.isNaN(y)) {
                    series.add(x, Double.NaN); // вставляем "дырку"
                } else {
                    series.add(x, y);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // dataset с одной серией
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // создаём график
        JFreeChart chart = ChartFactory.createXYLineChart(
                title,  // заголовок
                "x",    // подпись оси X
                "y",    // подпись оси Y
                dataset
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
