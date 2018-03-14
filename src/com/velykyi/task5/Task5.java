package com.velykyi.task5;

import java.util.Arrays;
import java.util.List;

public class Task5 {

    public static void main(String[] args) {

        int[] array = {1, 3, 5, 6, 7, -3, -45, -563, 34, 244, -56, -48, 35, 16,  563, 10000, 0, 0,0 ,-10000};


        List<Integer> list = Arrays.asList(1, 3, 5, 6, 7, -3, -45, -563, 34, 244, -56, -48, 35, 16,  563, 10000, 0, 0,0 ,-10000);


        list.sort((i1,i2) -> (((i1 > 0) && (i2 > 0)) ? i2 - i1 :i1 - i2) );

        list.stream()
                .forEach(System.out::println);




//        Quicksort quicksort = new Quicksort();
//        quicksort.sort(array);
//        System.out.println(Arrays.toString(array));
    }

}

class Quicksort {
    private int[] numbers;
    private int number;
    boolean flag = true;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot ;


        if (i == 0 && j == numbers.length - 1){
            pivot = 0;
        }  else {
            pivot = numbers[low + (high-low)/2];
            if (pivot > 0){
                flag = false;
            } else  {
                flag = true;
            }
        }


        while (i <= j) {

            if (!flag){
// sorting for positive numbers
                while ( numbers[i] > pivot) {
                    i++;
                }
                while ( numbers[j] < pivot) {
                    j--;
                }
            } else {
                while ( numbers[i] < pivot) {
                    i++;
                }
                while ( numbers[j] > pivot) {
                    j--;
                }
            }


            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        // Recursion
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
}
