package com.example.temperaturemonitoringsystem.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class ArrayService {

    // 1D Array: Daily temperature analysis
    public Map<String, Double> analyzeTemperatures(double[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException("Temperature array cannot be empty");
        }

        double max = Arrays.stream(temperatures).max().getAsDouble();
        double min = Arrays.stream(temperatures).min().getAsDouble();
        double avg = Arrays.stream(temperatures).average().getAsDouble();

        return Map.of(
            "max", max,
            "min", min,
            "avg", avg
        );
    }

    // 2D Array: Matrix operations
    public int[][] transposeMatrix(int[][] matrix) {
        return IntStream.range(0, matrix[0].length)
                .mapToObj(i -> IntStream.range(0, matrix.length)
                        .map(j -> matrix[j][i])
                        .toArray())
                .toArray(int[][]::new);
    }
}