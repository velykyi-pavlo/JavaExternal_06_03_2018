package com.velykyi.task2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 5}
                , {0, 4, 2, 3}
                , {10, 13, 5, 6}};

        double[] arrayAverageByColum = getArrayAverageByColum(matrix);

        // modified sorting, which takes an matrix in the form of which
        // will be sorted columns in the matrix
        Quicksort quicksort = new Quicksort();

        quicksort.sort(arrayAverageByColum, matrix);

        for (int[] a :
                matrix) {
            System.out.println(Arrays.toString(a));
        }
    }


    private static double[] getArrayAverageByColum(int[][] matrix) {
        double[] result = new double[matrix[1].length];
        double sum = 0.0;
        for (int j = 0; j < result.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j];
            }
            result[j] = sum / matrix.length;
            sum = 0;
        }
        return result;
    }

}

class Quicksort {
    private double[] numbers;
    private int number;
    private int[][] matrix;

    public void sort(double[] values, int[][] matrix) {

        if (values == null || values.length == 0) {
            return;
        }

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        this.numbers = values;
        this.matrix = matrix;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        double pivot = numbers[low + (high - low) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                swapColumByIndex(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        double temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private void swapColumByIndex(int i, int j) {
        int temp2 = 0;
        for (int k = 0; k < this.matrix.length; k++) {
            temp2 = matrix[k][i];
            matrix[k][i] = matrix[k][j];
            matrix[k][j] = temp2;
        }
    }
}
