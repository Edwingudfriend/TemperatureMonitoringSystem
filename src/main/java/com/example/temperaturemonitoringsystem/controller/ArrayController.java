package com.example.temperaturemonitoringsystem.controller;

import com.example.temperaturemonitoringsystem.service.ArrayService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for array manipulation operations.
 * Provides endpoints for temperature analysis and matrix transposition.
 */

@RestController
@RequestMapping("/api/arrays")
public class ArrayController {

    /**
     * Analyzes an array of temperature readings
     * @param temperatures Array of daily temperature values in Celsius
     * @return Analysis results including average, min, max, or error message
     */

    private final ArrayService arrayService;

    public ArrayController(ArrayService arrayService) {
        this.arrayService = arrayService;
    }

    // 1D Array endpoint
    @PostMapping("/temperature")
    public ResponseEntity<?> analyzeTemperatures(@RequestBody double[] temperatures) {
        try {
            return ResponseEntity.ok(arrayService.analyzeTemperatures(temperatures));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    /**
     * Transposes a given matrix (swaps rows with columns)
     * @param matrix 2D integer array representing the matrix to transpose
     * @return Transposed matrix
     * @throws  if input is not a valid matrix
     */
    // 2D Array endpoint
    @PostMapping("/transpose")
    public int[][] transposeMatrix(@RequestBody int[][] matrix) {
        return arrayService.transposeMatrix(matrix);
    }
}