package day3;

import java.util.Scanner;

public class Codeforce282A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int x = 0;
        while (n-- > 0){
            String s = in.nextLine();
            if (s.equals("X++") || s.equals("++X"))x++;
            else x--;
        }
        System.out.print(x);
    }
}
