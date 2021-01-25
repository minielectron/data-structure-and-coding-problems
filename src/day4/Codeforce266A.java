package day4;

import java.util.Scanner;

public class Codeforce266A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String word = in.nextLine();
        String previous = word.substring(0,1);
        int count = 0;
        for (int i = 1 ; i < n ; i++){
            String current = String.valueOf(word.charAt(i));
            if (previous.equals(current)){
                count++;
            }else previous = current;
        }
        System.out.print(count);
    }
}
