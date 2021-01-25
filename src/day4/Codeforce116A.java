package day4;

import java.util.Scanner;

public class Codeforce116A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min = 0;
        int max = 0;
        while (n-- > 0) {
            int exits = in.nextInt();
            int enters = in.nextInt();
            min += (enters - exits);
            if (max < min) max = min;
        }
        System.out.print(Math.abs(max));
    }
}

/*
* 4
0 3
2 5
4 2
4 0*/
