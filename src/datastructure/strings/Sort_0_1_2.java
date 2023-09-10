package datastructure.strings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Sort_0_1_2 {

    public static void main(String[] args) {
        int[] input = new int[10000000];
        for (int i = 0; i < input.length; i++) {
            Random r = new Random();
            int val = r.nextInt(3);
            input[i] = val;
        }

        print(Arrays.toString(input), "input.txt");
        print(Arrays.toString(sortArray_0_1_2(input)), "output1.txt");
        print(Arrays.toString(sortArray_0_1_2_(input)), "output2.txt");
    }

    static void print(String s, String filename) {
        File file = new File(filename);
        try {
            if (file.createNewFile()){
                FileWriter writer = new FileWriter(file);
                writer.append("Next");
                writer.append(s);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int[] sortArray_0_1_2_(int[] nums) {
        //Counting Sort Algorithm

        // Make three variables
        // For counting 0,1 and 2 respectively
        int count0 = 0, count1 = 0, count2 = 0;

        //Iterate through the datastructure.array and count the frequencies of each number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            if (nums[i] == 1) {
                count1++;
            }
            if (nums[i] == 2) {
                count2++;
            }
        }

        //Fill the original datastructure.array
        //First fill all 0, then 1 and at last 2
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

        return nums;

    }

    static int[] sortArray_0_1_2(int[] nums) {

        //Three Pointers Approach

        //Make a pointer for left (0)
        int left = 0;
        //Make a pointer for right (2)
        int i = 0;
        //Make a pointer for current (1)
        int right = nums.length - 1;

        //Iterate till i<=right
        while (i <= right) {
            //Case if nums[i]==0
            //Swap its value with nums[left]
            //Increment left
            if (nums[i] == 0) {
                swap(nums, i++, left++);
            }

            // nums[i] is 1, check next one
            //Increment i
            else if (nums[i] == 1) {
                i++;
            }

            //Case if nums[i]==2
            //Swap it with the right pointer
            //Decrement right pointer
            else {
                swap(nums, i, right--);
            }
        }

        return nums;
    }

    //Helper function for swapping
    static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
