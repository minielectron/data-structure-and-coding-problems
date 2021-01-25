import java.util.Scanner;

public class Codeforce41A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        String rev = reverse(t);
        if (s.equals(rev)) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

    static String reverse(String org) {
        StringBuilder temp = new StringBuilder();
        for (int i = org.length() - 1; i >= 0; i--) {
            temp.append(org.charAt(i));
        }
        return new String(temp);
    }
}
