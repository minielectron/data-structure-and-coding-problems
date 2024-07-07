package sorting;

public class InsertionSort {
    private final int[] nums;

    public InsertionSort(int[] nums) {
        this.nums = nums;
    }

    // In every iteration we bubble up the largest item to final position
    public void sort() {

        for (int i = 1; i < nums.length; ++i) {
            int j = i;

            // insertion sort make a lot of shifts
            while (j> 0 && nums[j-1] > nums[j]){
                swap(j, j-1);
                j--;
            }
        }
        showSortedArray();
    }

    private void showSortedArray() {
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5, 2, 6, 8, 1, 0, 11};
        InsertionSort bubbleSort = new InsertionSort(input);
        bubbleSort.sort();
    }
}
