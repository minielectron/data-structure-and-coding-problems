package sorting;

public class BogoSort {

    // this is not efficient on classic computers O(N!)

    private int[] nums;
    private int counter;

    public BogoSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {
        while (!isSorted()) {
            counter++;
            shuffle();
        }

        showSortedArray();
    }

    private void showSortedArray() {

        System.out.println("Number of tries = " + counter);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }

    }

    // Fisher-Yates algorithm to generate a random permutation in O(N)
    // the algorithm produces an unbiased permutation : every permutation is equally likely
    // in place algorithm
    private void shuffle() {
        for (int i = nums.length - 1; i > 0; --i) {
            int j = (int) (Math.random() * i);
            swap(i, j);
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean isSorted() {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5, 2, 6, 8, 1, 0, 11};
        BogoSort sort = new BogoSort(input);
        sort.sort();
    }
}
