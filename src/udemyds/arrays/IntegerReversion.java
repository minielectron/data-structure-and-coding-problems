package udemyds.arrays;

public class IntegerReversion {

    // 1234 - 4321

    public int reverse(int number){
        int output = 0;

        while (number != 0){
            output = output * 10 + number % 10;
            number /= 10;
        }

        return output;
    }

    public static void main(String[] args) {
        IntegerReversion reversion = new IntegerReversion();
        System.out.println(reversion.reverse(12345));
    }
}
