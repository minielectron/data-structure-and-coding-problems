package day2;

import java.util.Scanner;

public class Codeforce1328A {

    /*
     * You are given two positive integers a and b. In one move you can increase a by 1 (replace a with a+1). Your task is to find the minimum number of moves you need to do in order to make a divisible by b. It is possible, that you have to make 0 moves, as a is already divisible by b. You have to answer t independent test cases.*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            int a = Integer.parseInt(in.next());
            int b = Integer.parseInt(in.next());
            if (a % b == 0) System.out.println(0);
            else System.out.println(b - a % b);
        }
    }
}

/*5
10 4
13 9
100 13
123 456
92 42*/

