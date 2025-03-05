package recursions;

import java.util.Random;

/*
 * This finds kth smallest element in unordered array in O(n) with no extra space.
 * */
public class QuickSelect {

    private int[] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }

    public int select(int k) {
        return quickSelect(0, nums.length - 1, k - 1);
    }

    // This is the selection phase
    public int quickSelect(int startIndex, int lastIndex, int k) {

        int pivot = partition(startIndex, lastIndex);

        if (pivot < k) {
            return quickSelect(pivot + 1, lastIndex, k);
        } else if (pivot > k) {
            return quickSelect(startIndex, pivot - 1, k);
        }

        return nums[pivot];
    }

    private int partition(int startIndex, int lastIndex) {
        int pivot = new Random().nextInt(lastIndex - startIndex + 1) + startIndex;
        swap(pivot, lastIndex);

        for (int i = startIndex; i < lastIndex; i++) {
            if (nums[i] < nums[lastIndex]) { // change to nums[i] > nums[lastIndex] for kth max
                swap(i, startIndex);
                startIndex++;
            }
        }

        swap(lastIndex, startIndex);
        // Index of pivot is at start index
        return startIndex;
    }

    public void sort() {
        for (int i = 1; i < nums.length + 1; i++) {
            System.out.println(select(i));
        }
    }

    private void swap(int pivot, int lastIndex) {
        int temp = nums[pivot];
        nums[pivot] = nums[lastIndex];
        nums[lastIndex] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, -5, 10, 55, 3, -7, 7, 11, 100};
        QuickSelect quickSelect = new QuickSelect(input);
        System.out.println(quickSelect.select(2));
        System.out.println(quickSelect.select(1));
        System.out.println(quickSelect.select(3));
//        quickSelect.sort();
    }
}
