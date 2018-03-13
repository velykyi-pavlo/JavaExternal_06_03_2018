package com.velykyi.task2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 5}
                        ,{0, 4, 2, 3}
                        ,{10, 13, 5, 6}};
        for (int[] a :
                array) {
            System.out.println(Arrays.toString(a));
        }

        double[] arrayAverageByColum = getArrayAverageByColum(array);

        System.out.println(Arrays.toString(arrayAverageByColum));
        // modified sorting, which takes an array in the form of which
        // will be sorted columns in the matrix
        Quicksort quicksort = new Quicksort();

        quicksort.sort(arrayAverageByColum, array);

        System.out.println(Arrays.toString(arrayAverageByColum));

        for (int[] a :
                array) {
            System.out.println(Arrays.toString(a));
        }
    }


    private static double[] getArrayAverageByColum(int[][] array) {
        double[] arrayAverageByColum = new double[4];
        double sum = 0.0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < array.length; i++) {
              sum+= array[i][j];
            }
            arrayAverageByColum[j] = sum / array.length;
            sum = 0;
        }
        return arrayAverageByColum;
    }

}

class Quicksort  {
    private double[] numbers;
    private int number;
    private int[][] arrays;

    public void sort(double[] values, int[][] arrays) {

        if (values ==null || values.length==0){
            return;
        }
        if (arrays ==null || arrays.length==0){
            return;
        }
        this.numbers = values;
        this.arrays = arrays;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;

        double pivot = numbers[low + (high-low)/2];


        while (i <= j) {

            while (numbers[i] < pivot) {
                i++;
            }

            while (numbers[j] > pivot) {
                j--;
            }


            if (i <= j) {
                exchange(i, j);
                swapColumByIndex( i, j);
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

    private  void swapColumByIndex( int i, int j) {
        int temp2 = 0;
        for (int k = 0; k < this.arrays.length; k++) {
            temp2 = arrays[k][i];
            arrays[k][i] = arrays[k][j];
            arrays[k][j] = temp2;
        }
    }
}
