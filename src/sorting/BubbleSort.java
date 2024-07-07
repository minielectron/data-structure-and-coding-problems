package sorting;

public class BubbleSort {
    private int[] nums;

    public BubbleSort(int[] nums) {
        this.nums = nums;
    }

    // In every iteration we bubble up the largest item to final position
    public void sort() {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = 0; j < nums.length - i - 1; ++j) {
                if (nums[j] > nums[j + 1]) {
                    swap(j + 1, j);
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
        BubbleSort bubbleSort = new BubbleSort(input);
        bubbleSort.sort();
    }
}
