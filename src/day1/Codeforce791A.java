package day1;

import java.util.Scanner;

public class Codeforce791A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int limak = Integer.parseInt(in.next());
        int bob = Integer.parseInt(in.next());
        int year = 0;
        while ( limak <= bob){
            limak*=3;
            bob*=2;
            year++;
        }
        System.out.println(year);
    }
}


