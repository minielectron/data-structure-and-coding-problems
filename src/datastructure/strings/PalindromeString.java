package datastructure.strings;

public class PalindromeString {

    public static void main(String[] args) {
        PalindromeString p = new PalindromeString();
        System.out.println(p.validPalindrome("123454321"));
    }

    public boolean validPalindrome(String p) {

        String s = p.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            if (!(Character.isLetterOrDigit(s.charAt(start)))) {
                start++;
                continue;
            }

            if (!(Character.isLetterOrDigit(s.charAt(end)))) {
                end--;
                continue;
            }

            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }

        }
        return true;
    }
}
