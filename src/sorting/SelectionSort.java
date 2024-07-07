package sorting;

public class SelectionSort {
    private final int[] nums;

    public SelectionSort(int[] nums) {
        this.nums = nums;
    }

    // In every iteration we bubble up the largest item to final position
    public void sort() {
        for (int i = 0; i < nums.length - 1; ++i) {

            // LINEAR_SEARCH for min item, and swap with left most item
            int index = i;
            for (int j = i+1 ; j < nums.length; ++j) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            if (index != i){
                // One swap in each iteration at max
                swap(index, i);
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
        SelectionSort bubbleSort = new SelectionSort(input);
        bubbleSort.sort();
    }
}
