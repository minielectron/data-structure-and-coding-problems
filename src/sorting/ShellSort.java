package sorting;

public class ShellSort {
    private final int[] nums;

    public ShellSort(int[] nums) {
        this.nums = nums;
    }

    // In every iteration we bubble up the largest item to final position
    public void sort() {

        for (int gap = nums.length / 2; gap > 0; gap = gap / 2) { // decreasing step by 2 division
            for (int i = gap; i < nums.length; ++i) {
                int j = i;

                while (j >= gap && nums[j - gap] > nums[j]) {
                    swap(j, j - gap);
                    j = j - gap;
                }
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
        ShellSort bubbleSort = new ShellSort(input);
        bubbleSort.sort();
    }
}
