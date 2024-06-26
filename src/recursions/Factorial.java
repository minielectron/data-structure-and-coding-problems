package recursions;

public class Factorial {
    public int head(int n) {
        if (n == 1) return 1;
        return n * head( n - 1);
    }

    public int tail(int n, int result) {
        if (n == 0) return result;
        return tail(n - 1, result * n);
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.head(5));
        System.out.println(f.tail(5, 1));
    }
}
