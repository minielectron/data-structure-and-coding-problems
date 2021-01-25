package day5;

import java.util.Scanner;

public class Codeforce59A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int min = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
                min++;
        }
        if (word.length() / 2.0 > min) { // decimal division is important
            System.out.println(word.toUpperCase());
        } else System.out.println(word.toLowerCase());
    }
}
