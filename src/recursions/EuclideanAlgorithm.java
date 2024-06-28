package recursions;

public class EuclideanAlgorithm {

    public static void main(String[] args) {
        EuclideanAlgorithm algorithm = new EuclideanAlgorithm();
        System.out.println(algorithm.findGcd(45, 10));
        System.out.println(algorithm.findGcd(25, 16));
        System.out.println(algorithm.findGcd(16, 14));
    }

    public int findGcd(int a, int b) {
        if (a < b) return 1;
        if (a % b == 0) return b;
        return findGcd(b, a % b);
    }
}
