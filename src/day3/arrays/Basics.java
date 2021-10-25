package day3.arrays;

import java.util.Arrays;

public class Basics {
    private int x[] = new int[5]; // will be initialized with zero
    private int y[]; // It's just an declaration and cannot be accessed as no memory is assigned tot it.

    public static void main(String[] args) {

        Basics b = new Basics();
        int arr[] = new int[10]; // by default it will be initialized with zero
        System.out.println(Arrays.toString(arr));
//        b.x[5] = 218; // will throw index out of bound exception
        b.x[4] = 218; // Assign 218 to last position in the datastructure.array
        System.out.println(Arrays.toString(b.x));
//        b.y[3] = 29388; // will give null pointer exception
        b.y = new int[10];
        b.y[0] = 2983;
        System.out.println(Arrays.toString(b.y)); // it throw null pointer exception
    }
}
