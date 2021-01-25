package day5;

import java.util.Scanner;

public class Codeforce266b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        in.nextLine();
        String q = in.nextLine();
        char[] x = q.toCharArray();
        for (int j = 0; j < t; j++) {
            q = new String(x);
            for (int i = 0; i < n - 1; ) {
                if (q.charAt(i) == 'B' && q.charAt(i + 1) == 'G') {
                    x[i] = q.charAt(i + 1);
                    x[i + 1] = q.charAt(i);
                    i = i + 2;
                } else i++;
            }
        }
        System.out.println(new String(x));
    }
}
