package day4;

import java.util.Scanner;

public class Codeforce617A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while (n > 0) {
            if (n >= 5) {
                count++;
                n = n - 5;
            } else if (n >= 4) {
                count++;
                n = n - 4;
            } else if (n >= 3) {
                count++;
                n = n - 3;
            } else if (n >= 2) {
                count++;
                n = n - 2;
            } else {
                count++;
                n = n - 1;
            }
        }
        System.out.print(count);
    }
}

/*
* 4
0 3
2 5
4 2
4 0*/
