package org.example.util;

import org.example.math.trig.Sin;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Graph extends JFrame{
    public Graph(String title, String functionName, Function function) {
        super(title);

        XYSeries series = new XYSeries(functionName);

        for (double x = -2 * Math.PI; x <= 2 * Math.PI; x += 0.1) {
//            series.add(x, function.apply(x));
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                "x",
                "y",
                dataset
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
