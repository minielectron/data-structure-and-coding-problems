package integer;

public class PalindromeNumber {

    public static void main(String[] args) {
        print(isPalindrome(12321));
        print(isPalindrome(12341));
        print(isPalindrome(0));
        print(isPalindrome(121121));
    }

    static boolean isPalindrome(int x) {
        // n = 12321
        // how many  times this number can be divided
        double log = Math.log10(x);
        // total number of digit = Floor of log + 1
        int totalDigits = (int) Math.floor(log) + 1;
        int mask = (int) Math.pow(10, totalDigits - 1); // 10000

        for (int i = 0; i < totalDigits / 2; i++) {
            int mostSignificantDigits = x / mask; // = 1
            int onesPlaceDigits = x % 10; // = 1
            if (mostSignificantDigits != onesPlaceDigits) return false;
            x %= mask; // 2321
            x /= 10; // 232
            mask /= 100; // 100
        }

        return true;
    }

    static void print(Object object){
        System.out.println(object);
    }
}
