package day2;

import java.util.Scanner;

public class Codeforce734A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int a = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') a++;
            else d++;
        }

        if (a > d) System.out.println("Anton");
        else if(d > a)System.out.println("Danik");
        else System.out.println("Friendship");
    }
}
