package day11;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class EnumeratePrimeNumber {
    public static void main(String[] args) {

        System.out.println(printPrime(1000000));
//        System.out.println(primes(1000000));
        System.out.println(enumeratePrimes(1000000));
    }


    public static List<Integer> printPrime(int n) {
        Instant start = Instant.now();
        if (n == 1) return new ArrayList<>();
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n - 1; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        Instant end = Instant.now();
        System.out.println(String.format("Basic : %d/n", (start.toEpochMilli()) - end.toEpochMilli()));
        return primes;
    }


    public static List<Integer> primes(int n) {
        // Seive of eratheosis

        Instant start = Instant.now();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            nums.add(i);
        }

        for (int i = 0; i <= nums.size() / 2; i++) {
            int num = nums.get(i);
            int j = 2;
            while (num * j < n) {
                nums.remove(Integer.valueOf(num *j));
                j++;
            }
        }
        Instant end = Instant.now();
        System.out.println(String.format("Basic+ : %d", (start.toEpochMilli()) - end.toEpochMilli()));
        return nums;
    }

    public static List<Integer> enumeratePrimes(int n) {

        Instant start = Instant.now();
        if (n <= 1) {
            return new ArrayList<>();
        }

        List<Integer> output = new ArrayList<>();
        boolean[] isPrime = new boolean[n];

        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 0; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < n; j += i) {
                    isPrime[j] = false;
                }

                output.add(i);
            }
        }
        Instant end = Instant.now();
        System.out.println(String.format("Basic++ : %d", (start.toEpochMilli()) - end.toEpochMilli()));

        return output;
    }
}
