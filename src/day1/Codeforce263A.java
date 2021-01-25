package day1;

import java.util.Scanner;

public class Codeforce263A {

  /*
  * You've got a 5 × 5 matrix, consisting of 24 zeroes and a single number one. Let's index the matrix rows by numbers from 1 to 5 from top to bottom, let's index the matrix columns by numbers from 1 to 5 from left to right. In one move, you are allowed to apply one of the two following transformations to the matrix:

Swap two neighboring matrix rows, that is, rows with indexes i and i + 1 for some integer i (1 ≤ i < 5).
Swap two neighboring matrix columns, that is, columns with indexes j and j + 1 for some integer j (1 ≤ j < 5).
You think that a matrix looks beautiful, if the single number one of the matrix is located in its middle (in the cell that is on the intersection of the third row and the third column). Count the minimum number of moves needed to make the matrix beautiful.

Input
The input consists of five lines, each line contains five integers: the j-th integer in the i-th line of the input represents the element of the matrix that is located on the intersection of the i-th row and the j-th column. It is guaranteed that the matrix consists of 24 zeroes and a single number one.*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 0, y = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                if (in.nextInt() == 1) {
                    x = i + 1;
                    y = j + 1;
                    break;
                }
            }
        int movex = 0, movey = 0;
        if (x > 3) {
            movex = x % 3;
        } else movex = 3 - x;
        if (y > 3) {
            movey = y % 3;
        } else movey = 3 - y;

        System.out.println(movex + movey);
    }
}


