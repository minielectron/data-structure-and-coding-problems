public class Memoization {

    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(fib(10) + "\n");
        System.out.println("Calls : "+ count + "\n");
        count = 0;
        int n = 50;
        System.out.println(fibM(n, new int[n+1]) +"\n");
        System.out.println("Calls : "+ count +"\n");
    }

    /*Find sum of fibonacci series upto n - The below algorithm takes O(2^n) Time complexity*/
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        count++;
        return fib(n - 1) + fib(n - 2);
    }

    /*With memoization*/

    public static int fibM(int n, int[] cache){
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        count ++;
        if (cache[n] == 0){
            cache[n] = fibM(n-1, cache) + fibM(n-2, cache);
            System.out.println(cache[n]);
        }
        return cache[n];
    }
}

