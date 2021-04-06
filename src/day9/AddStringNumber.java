package day9;

public class AddStringNumber {
    public static String addStrings(String s1, String s2) {
        int max = Math.max(s1.length(), s2.length());

        String result = "" ;
        int carry = 0 ;
        int l = s1.length() - 1 ;
        int r = s2.length() - 1 ;

        while (max-- > 0){

            int a = 0 ;
            int b = 0 ;

            if (l >= 0) a = Integer.parseInt(String.valueOf(s1.charAt(l--)));
            if (r >= 0) b = Integer.parseInt(String.valueOf(s2.charAt(r--)));

            int sum = a + b + carry;
            int res = sum % 10 ;
            result = String.format("%s%s", res, result);
            carry = sum / 10 ;
        }

        String output;
        if (carry == 0 )
            output = result;
        else
            output = String.format("%s%s", carry, result);
        return output;
    }

    public static void main(String[] args) {
        System.out.println(addStrings("75","9"));
    }

    public String addStringsOptimal(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;

        /* Strings are immutable in Java, so use StringBuilder for efficiency. */
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += (s1.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                sum += (s2.charAt(j) - '0');
                j--;
            }
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
