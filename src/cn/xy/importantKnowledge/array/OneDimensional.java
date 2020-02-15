package cn.xy.importantKnowledge.array;

import java.util.Arrays;

public class OneDimensional {
    int[] array = new int[]{5, 6, 7, 8, 9};
    int[] array1 = new int[5];
    int[][] array2 = new int[][]{
            {1, 2, 3, 4, 5},
            {7, 8, 9, 4, 5},
            {45, 67, 89, 45, 1}
    };

    private OneDimensional() {
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        // print one-dimensional array
        for (int i : array) {
            System.out.println(array[i - 1]);
        }
        // copy one-dimensional array and print
        System.arraycopy(array, 0, array1, 0, 3);
        for (int i : array1) {
            System.out.println(i);
        }
        // print a two-dimensional array
        int count = 0;
        for (int[] i : array2) {
            for (int j : i) {
                System.out.print(j + "\t");
                count++;
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }

        // use Arrays class's toString method make array change string
        for (int[] i : array2) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
        OneDimensional oneDimensional = new OneDimensional();
    }
}
