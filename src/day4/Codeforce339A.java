import java.util.Arrays;
import java.util.Scanner;

public class Codeforce339A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split("\\+");
        int[] numbers = new int[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(numbers);
        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number).append("+");
        }
        System.out.print(result.substring(0,result.length()-1));
    }
}
