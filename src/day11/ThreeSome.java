package day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSome {


    public List<List<Integer>> threeSum(int[] A) {
        List<List<Integer>> triplet = new ArrayList<>();
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            find3Sum(A, i, triplet);
        }

        return triplet;
    }

    private void find3Sum(int[] a, int i, List<List<Integer>> triplet) {
        int leftPointer = i + 1;
        int rightPointer = a.length - 1;

        while (leftPointer < rightPointer) {
            int sum = a[i] + a[leftPointer] + a[rightPointer];

            if (sum == 0) {
                triplet.add(Arrays.asList(a[i], a[leftPointer++], a[rightPointer--]));
            } else if (sum < 0) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
    }


    public static void main(String[] args) {
        ThreeSome t = new ThreeSome();
        List<List<Integer>> r = t.threeSum(new int[]{9, 8, 7, 6, 5, 4, 3, 1, -4, -2});
        for (List<Integer> i : r) {
            System.out.println(i.toString());
        }
    }

}


