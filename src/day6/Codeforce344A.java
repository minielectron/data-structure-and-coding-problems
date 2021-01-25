package day6;

import java.util.Scanner;

public class Codeforce344A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 1;
        int n = in.nextInt();
        int current = in.nextInt();
        while (n-- > 1){
            int next = in.nextInt();
            if (current != next){
                current = next;
                count++;
            }
        }
        System.out.println(count);
    }
}
