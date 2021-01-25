package day2;

import java.util.Scanner;

public class Codeforce705A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String love = "I love ";
        String hate = "I hate ";
        String that = "that ";
        String end = "it";
        StringBuilder result = new StringBuilder(hate);
        int n = in.nextInt();
        for (int i = 2 ; i <= n; i++){
            result.append(that);
            if (i % 2 == 0){
                result.append(love);
            }else result.append(hate);
        }
        result.append(end);
        System.out.println(result);

    }
}
