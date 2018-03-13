package com.velykyi.task4;

import java.util.Arrays;

public class Task4 {


    public static void main(String[] args) {


        int[] array = {1, 3, 5, 6, 7, -3, -45, -563, 34, 244, -56};

        sortWhithSaveingPosition(array);

//        quickSort(array);



        System.out.println(Arrays.toString(array));


    }

    private static void quickSort(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int pivot = 0;

        while (i <= j) {
            while (array[i] > pivot){
                i++;
            }
            while (array[j] < pivot){
                j--;
            }
            if (i <= j) {
               int temp = array[i];
               array[i] = array[j];
               array[j] = temp;
               i++;
               j--;
            }
        }
    }

    private static void sortWhithSaveingPosition(int[] array) {
        int j = 0;
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < 0) {
                continue;
            }
            temp = array[i];
            j = i - 1;
            while (j >= 0 && array[j] < 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
    }
}
