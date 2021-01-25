package day4;

import java.util.Scanner;

public class Codeforce236A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();
        StringBuilder name = new StringBuilder();
        for (int i = 0 ; i < username.length(); i++){
            String ch = String.valueOf(username.charAt(i));
            if (!name.toString().contains(ch))
                name.append(ch);
        }
        if (name.length() %2 == 0){
            System.out.print("CHAT WITH HER!");
        }else System.out.print("IGNORE HIM!");
    }
}
