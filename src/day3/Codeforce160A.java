import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Codeforce160A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] coins = new Integer[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
            sum += coins[i];
        }
        int requiredSum = (int) Math.ceil(sum / 2d);
        Arrays.sort(coins, Collections.reverseOrder());
        sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sum > requiredSum) break;
            sum += coins[i];
            count++;
        }
        System.out.println(count);
    }
}
