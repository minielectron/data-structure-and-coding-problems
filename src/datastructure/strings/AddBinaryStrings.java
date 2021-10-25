package datastructure.strings;

public class AddBinaryStrings {

    public static void main(String[] args) {
        AddBinaryStrings a = new AddBinaryStrings();
        System.out.println(a.addBinaryStrings("1001", "1"));
    }

    public String addBinaryStrings(String s1, String s2) {
        /* We use two pointers to traverse our two datastructure.strings in reverse order. */
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        /* We will construct our answer as we traverse the datastructure.strings. */

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0) {

            /* On the first iteration, sum is always set to zero. */
            int sum = carry;
            //If First string has unvisited characters
            if (i >= 0) {
                sum += s1.charAt(i--) - '0';
            }

            //If second string has unvisited characters
            if (j >= 0) {
                sum += s2.charAt(j--) - '0';
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }
        //If extra carry is left
        if (carry != 0) {
            sb.append(carry);
        }
        /* Since we constructed the string backwards, we must reverse the string to obtain our solution. */
        return sb.reverse().toString();
    }
}
