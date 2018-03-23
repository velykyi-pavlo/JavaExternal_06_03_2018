package com.sorting.task2;

import java.util.Arrays;

public class Task2_2 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 5, 3, 3, 5, 5, 5}
                         ,{5, 4, 6, 2, 6, 1, 5, 5}
                         ,{9, 3, 5, 6, 5, 3, 5, 5}};

        int[] mostPopulatInRow = getArrayMostPopulatInRow(matrix);


        // modified sorting, which takes an matrix in the form of which
        // will be sorted columns in the matrix
        Quicksort2 quicksort = new Quicksort2();

        quicksort.sort(mostPopulatInRow, matrix);

        for (int[] a :
                matrix) {
            System.out.println(Arrays.toString(a));
        }
    }


    private static int[] getArrayMostPopulatInRow(int[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = findPopular(matrix[i]);
        }
        return result;
    }

    public static int findPopular(int[] a1) {

        if (a1 == null || a1.length == 0)
            return 0;

        int[] a = a1.clone();
        Arrays.sort(a);

        int previous = a[0];
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == previous)
                count++;
            else {
                if (count > maxCount) {
                    maxCount = count;
                }
                previous = a[i];
                count = 1;
            }
        }

        return count > maxCount ? count : maxCount;

    }

}

class Quicksort2 {
    private int[] numbers;
    private int number;
    private int[][] matrix;

    public void sort(int[] values, int[][] matrix) {

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
                swapRowByIndex(i, j);
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
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private void swapRowByIndex(int i, int j) {
        int temp2 = 0;
        for (int k = 0; k < this.matrix[0].length; k++) {
            temp2 = matrix[i][k];
            matrix[i][k] = matrix[j][k];
            matrix[j][k] = temp2;
        }
    }
}