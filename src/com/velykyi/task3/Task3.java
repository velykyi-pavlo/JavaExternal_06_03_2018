package com.velykyi.task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}
                , {10, 11, 12, 5}
                , {9, 8, 7, 6}};

        List spiral = spiralResult(array);
        System.out.println(spiral);





    }

    public static List spiralResult(int[][] matrix) {
        List result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }


        int left_coordinate = 0;
        int right_coordinate = matrix[0].length - 1;
        int top_coordinate = 0;
        int down_coordinate = matrix.length - 1;

        while (result.size() < matrix[0].length * matrix[0].length) {
            for (int j = left_coordinate; j <= right_coordinate; j++) {
                result.add(matrix[top_coordinate][j]);
            }
            top_coordinate++;

            for (int i = top_coordinate; i <= down_coordinate; i++) {
                result.add(matrix[i][right_coordinate]);
            }
            right_coordinate--;

            if (down_coordinate < top_coordinate)
                break;

            for (int j = right_coordinate; j >= left_coordinate; j--) {
                result.add(matrix[down_coordinate][j]);
            }
            down_coordinate--;

            if (right_coordinate < left_coordinate)
                break;

            for (int i = down_coordinate; i >= top_coordinate; i--) {
                result.add(matrix[i][left_coordinate]);
            }
            left_coordinate++;
        }

        return result;
    }
}