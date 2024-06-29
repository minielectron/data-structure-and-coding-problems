package recursions;

public class CountBits {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(120));
        CountBits bits = new CountBits();
//        System.out.println(bits.countBits(120));
//        System.out.println(bits.countBits(3));
//        System.out.println(bits.countBits(16));
//        System.out.println(bits.checkEven(10));
//        System.out.println(bits.checkEven(11));
//        System.out.println(bits.checkEven(1011011));
//        System.out.println(bits.checkEven(1011012));
        System.out.println(bits.russianPeasantProblem(2, 4));
        System.out.println(bits.russianPeasantProblem(2, 5));
    }

    public boolean checkEven(int n) {
        // 1010 - 10
        // 0001 - XOR
        // 1011 - 11 --> XOR increases by 1 for even and decreases by 1 for odd number

        return (n ^ 1) == n + 1;
    }

    public int countBits(int n) {
        int counter = 0;

        while (n > 0) {
            counter++;
            n = n >> 1;
        }
        return counter;
    }

    public int russianPeasantProblem(int a, int b) {
        // a x b = 2a x b/2 works for even, because in odd its integer division
        int result = 0;

        while (b > 0) {
            if ((b ^ 1) == b - 1) {
                result = result + a;
            }

            // double the first
            a = a << 1;
            // divide the second by 2
            b = b >> 1;
        }
        return result;
    }
}
