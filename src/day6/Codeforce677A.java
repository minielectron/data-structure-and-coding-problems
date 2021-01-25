package day6;

import java.util.Scanner;

public class Codeforce677A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int width = 0;
        int n = in.nextInt();
        int mh = in.nextInt();
        while (n-- > 0) {
            int h = in.nextInt();
            if (h > mh) width += 2;
            else width += 1;
        }
        System.out.println(width);
    }
}
