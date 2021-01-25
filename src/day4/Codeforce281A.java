package day4;

import java.util.Scanner;

public class Codeforce281A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        System.out.print(String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1));
    }
}
