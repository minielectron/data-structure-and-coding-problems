package udemyds.arrays;

public class Palindrome {

    public boolean solve(String s){
        int forward = 0;
        int backward = s.length() - 1;

        while (forward < backward){
            if (s.charAt(forward) != s.charAt(backward)){
                return false;
            }
            forward ++;
            backward --;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.solve("madam"));
    }
}
