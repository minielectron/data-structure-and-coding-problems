package udemyds.arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 6, 2, 4, 1, 9, 10, 3};

        int startIndex = 0;
        int lastIndex = nums.length - 1;

        while (startIndex < lastIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            startIndex++;
            lastIndex--;
        }

        for (int num : nums) {
            System.out.println(num);
        }

    }

}
