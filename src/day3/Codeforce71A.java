package day3;

import java.util.Scanner;

public class Codeforce71A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String input = in.nextLine();
            if (input.length() > 10) {
                input = input.charAt(0) + String.valueOf(input.length() - 2) + input.charAt(input.length() - 1);
            }
            System.out.println(input);
        }
    }
}
