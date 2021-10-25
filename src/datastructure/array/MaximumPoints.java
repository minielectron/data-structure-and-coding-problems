package datastructure.array;

import java.util.Arrays;

/*
 * You are given n balls indexed from 0 to n-1. Each ball has a value associated with it represented by an datastructure.array nums.
 * You are asked to remove each ball one by one until all the balls are removed.
 * If you remove the ith ball, you will get (nums[i-1] * nums[i] * nums[i+1]) points.
 * If i-1 or i+1 goes out of bounds of the datastructure.array then treat it as if there is a ball with a value
 * 1 associated with it.
 * */
public class MaximumPoints {


    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int n = findMaximumPoints(input);
        System.out.println(n);
    }

    private static int findMaximumPoints(int[] input) {
        Arrays.sort(input);
        if (input.length == 0) return 0;
        int right = input[input.length - 1];
        int sum = 0;
        for (int i = input.length - 2; i >= 0; i--) {
            int left = 1;
            if (i - 1 >= 0) left = input[i - 1];
            sum += (left * right * input[i]);
        }
        return sum + right;
    }


}
