package day2;

import java.util.Scanner;

public class Codeforce1030A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String result = "";
        while (n-- > 0) {
            int opinion = in.nextInt();
            if (opinion == 1) {
                result = "HARD";
                break;
            }
        }
        if (result.equals("HARD"))
            System.out.println(result);
        else System.out.println("EASY");
    }
}
