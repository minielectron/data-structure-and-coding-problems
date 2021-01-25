package day3.arrays;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = {1, 2, 3, 4, 5, 6, 7};
        System.out.print(Arrays.toString(rotateLeftBy(arr, 2)));
        System.out.print(Arrays.toString(rotateRightBy(arr, 4)));
        System.out.print(Arrays.toString(reverse(arr)));
        System.out.print(Arrays.toString(reverse(b)));

    }

    static int[] rotateRightBy(int[] arr, int rotateBy) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[(i + rotateBy) % arr.length] = arr[i];
        }
        return temp;
    }

    static int[] rotateLeftBy(int[] arr, int rotateBy) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[(i + rotateBy) % arr.length];
        }
        return temp;
    }

    static int[] reverse(int[] a){
        for (int i = 0 ; i < a.length / 2 ; i++){
            int temp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = temp;
        }
        return a;
    }
}
