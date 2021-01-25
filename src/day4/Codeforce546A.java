package day4;

import java.util.Scanner;

public class Codeforce546A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int initialPrice = in.nextInt();
        int dollars = in.nextInt();
        int bananas = in.nextInt();
        int moneyNeeded = 0;
        while (bananas > 0) {
            moneyNeeded += initialPrice * bananas--;
        }
        int required = moneyNeeded - dollars;
        System.out.print(Math.max(required, 0));
    }
}
