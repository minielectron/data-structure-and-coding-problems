package datastructure.recursion;

import java.util.ArrayList;

public class Fibonacci {
    public static void main(String[] args) {
        // Print nth fibonacci series number

        // Base condition
        // f(0) = 0
        // f(1) = 1
        Fibonacci f = new Fibonacci();
//        System.out.print(f.fibonacci(4));
//        System.out.println();
//        f.printNNaturalNumbers(10);
//        System.out.println();
//        System.out.println(f.sumOfNNumbers(10));
//        System.out.println();
//        System.out.println(f.isPalindrome("abcba"));
//        System.out.println();
//        int [] input = new int[]{1,2,3,4,5,6,7,8,9};
//        System.out.println(f.binarySearch(3,  input, 0, input.length - 1));
//        System.out.println(f.factorial(5));
//        System.out.println(f.isSorted(new int[]{1,2,3,4,5,6}, 5));
//        System.out.println(f.isSorted(new int[]{1,2,4,3,5,6}, 5));
        int [] input  = new int[]{1,2,3};
        System.out.println(f.subsets(input));

    }

    int factorial(int n){
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
    int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    int sumOfNNumbers(int n){
        if (n == 1) return 1;
        return n + sumOfNNumbers(n - 1);
    }

    void printNNaturalNumbers(int n){
        if (n == 0) return;
        System.out.print(n);
        printNNaturalNumbers(n - 1);
    }

    boolean isPalindrome(String s){
        if (s.length() < 2) return true;
        if (s.charAt(0) != s.charAt(s.length()-1)) return false;
        return isPalindrome(s.substring(1,s.length()-1));
    }

    boolean binarySearch(int k, int[] arr, int start, int end){
        int mid = start + (end - start)/2;
        if(start > end) return false;
        if (arr[mid] == k) return true;
        if (k > mid){
            return binarySearch(k, arr, mid + 1, end);
        }else{
            return binarySearch(k, arr, start, mid - 1);
        }
    }


    public boolean isSorted(int [] arr, int n){
        if (n == 0) return true;
        if (arr[n] < arr[n - 1]){
            return false;
        }
        return isSorted(arr, n-1);
    }


    public String subsets(int[] input){
        ArrayList<Integer> result = new ArrayList<>();
        subsetsString(input, 0, result);
        return result.toString();
    }

    private void subsetsString(int [] arr, int index, ArrayList<Integer> result){
        if (arr.length == index){
            for (int num: result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // Include step
        result.addLast(arr[index]);
        subsetsString(arr, index + 1, result);

        // Exclude step
        result.removeLast();
        subsetsString(arr, index + 1, result);
    }
}

