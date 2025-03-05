package recursions;

public class HeadTailRecursion {
    public void head(int n) {
        System.out.println("Calling head function");
        if (n == 0) {
            return;
        }

        head(n - 1);
        System.out.println(n);
    }

    public void tail(int n) {
        System.out.println("Calling tail function");
        if (n == 0) {
            return;
        }

        System.out.println(n);
        tail(n - 1);
    }

    public int sum(int n) {
        if (n == 0) return 0;
        return n + sum(n - 1);
    }

    public int sum2(int n, int sum) {
        if (n == 1) return sum + 1;
        return sum2(n - 1, sum + n);
    }

    public static void main(String[] args) {
        HeadTailRecursion ht = new HeadTailRecursion();
//        ht.head(5);
//        ht.tail(5);
        System.out.println(ht.sum(5));
        System.out.println(ht.sum2(5, 0));
    }
}

