package day5;

import java.util.Scanner;

/*
* George has recently entered the BSUCP (Berland State University for Cool Programmers). George has a friend Alex who has also entered the university. Now they are moving into a dormitory.

George and Alex want to live in the same room. The dormitory has n rooms in total. At the moment the i-th room has p i people living in it and the room can accommodate q i people in total ( p i ≤ q i). Your task is to count how many rooms has free place for both George and Alex.*/
public class Codeforce467A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while (n-- > 0){
            int p = in.nextInt();
            int q = in.nextInt();
            if (q-p >= 2) count++;
        }
        System.out.println(count);
    }
}
