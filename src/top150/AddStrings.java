package top150;

/**
 *
 * Given two strings s1 and s2 consisting of digits between 0 to 9,
 * return a string representing the sum of s1 and s2 when they are considered as base-10 decimal numbers.
 * */
public class AddStrings {


    public static void main(String[] args) {
        String sum = sum("12345","12345");
        System.out.println(sum);
    }
    static String sum(String first, String second){
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int n = Math.max(first.length(), second.length());
        int smallString = Math.min(first.length(), second.length());
        for (int i = 0 ; i < smallString ; i++){
            int charSum = first.charAt(i) + second.charAt(i) + carry;
            carry = charSum/10;
            sum = new StringBuilder(charSum).append(sum);
        }

        if (n > smallString){
            for (int i = smallString; i < n; i++){
                int charSum = first.charAt(i) + second.charAt(i) + carry;
                carry = charSum/10;
                sum = new StringBuilder(charSum).append(sum);
            }
        }

        return sum.toString();
    }
}
