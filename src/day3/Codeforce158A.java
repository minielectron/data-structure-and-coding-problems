package day3;

import java.util.Scanner;

public class Codeforce158A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] scores = new int[n];
        int out = 0;
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            scores[i] = s;
        }
        for (int i = 0 ; i < n ; i++){
            if (scores[i] >= scores[k-1] && scores[i] > 0)
                out++;
        }
        System.out.print(out);
    }
}
