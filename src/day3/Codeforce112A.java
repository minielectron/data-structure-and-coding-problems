package day3;

import java.util.Scanner;

public class Codeforce112A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.nextLine().toLowerCase();
        String second = in.nextLine().toLowerCase();
        int result = first.compareTo(second);
        if (result > 0)
            System.out.print(1);
        else if (result < 0)
            System.out.print(-1);
        else System.out.print(0);
    }
}
