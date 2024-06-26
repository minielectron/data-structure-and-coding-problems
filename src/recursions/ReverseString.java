package recursions;

public class ReverseString {

    public String reverse(String s) {
        if (s.isEmpty()) return "";
        return s.charAt(s.length()-1) + reverse(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverse("Kevin"));
    }
}
