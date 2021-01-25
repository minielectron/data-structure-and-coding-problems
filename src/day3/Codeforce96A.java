package day3;

import java.util.Scanner;

public class Codeforce96A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String situation = in.nextLine().toLowerCase();

        if (situation.contains("1111111") || situation.contains("0000000"))
            System.out.println("YES");
        else System.out.println("NO");
    }
}

/*
* int teamA = 0, teamB = 0;
        for (int i = 0; i < situation.length(); i++) {
            if (situation.charAt(i) == '0') {
                teamA++;
                if (teamA == 7)
                    break;
                teamB = 0;
            } else {
                teamB++;
                if (teamB == 7) break;
                teamA = 0;
            }
        }
        if (teamA == 7 || teamB == 7)
            System.out.print("YES");
        else System.out.print("NO");

* */