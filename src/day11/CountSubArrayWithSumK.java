package day11;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithSumK {

    /*Given an datastructure.array of integers arr and an integer value k, return the total
    amount of unique, contiguous, subarrays that sum to k in arr.*/
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 0, -1, 1}, 0));
    }

    public static int countSubarrays(int[] arr, int k) {
        Map<Integer, Integer> table = new HashMap<>();
        table.put(0, 1);

        int sum = 0;
        int count = 0;
        for (int value : arr) {
            sum += value;

            if (table.containsKey(sum - k)) {
                count += table.get(sum - k);
            }

            if (table.containsKey(sum)) {
                table.put(sum, table.get(sum) + 1);
            } else {
                table.put(sum, 1);
            }
        }

        return count;
    }

}
