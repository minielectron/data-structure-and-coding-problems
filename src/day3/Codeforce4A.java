package day3;

import java.util.Scanner;

public class Codeforce4A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        if (w > 2 && w % 2 == 0) System.out.print("YES");
        else System.out.print("NO");
    }
}
