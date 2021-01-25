package hackerrank;

import java.util.Scanner;

public class JavaLoopsII {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int first = a + b;
            int previousSum = first;
            System.out.print(first + " ");
            for (int j = 1; j < n; j++) {
                int next = (int) (previousSum + (Math.pow(2, j) * b));
                previousSum = next;
                System.out.print(next + " ");
            }
        }
        in.close();
    }
}
