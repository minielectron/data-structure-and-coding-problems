import edu.princeton.cs.algs4.In;

import java.util.*;

public class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder output = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i <= word1.length() - 1 && j <= word2.length() - 1) {
            output.append(word1.charAt(i));
            output.append(word2.charAt(j));
            i++;
            j++;
        }

        if (i < word1.length()) {
            for (int k = i; k < word1.length(); k++) {
                output.append(word1.charAt(k));
            }
        }
        if (j < word2.length()) {
            for (int k = i; k < word2.length(); k++) {
                output.append(word2.charAt(k));
            }
        }

        return output.toString();
    }

    // LEET 1431
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> output = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }

        for (int i = 0; i < candies.length; i++) {
            output.add(candies[i] + extraCandies < max);
        }

        return output;
    }

    // LEET 605
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int emptySlots = 0;

        if (flowerbed.length == 1 && n == 1) {
            if (flowerbed[0] == 0)
                emptySlots++;
        }

        if (flowerbed.length == 1 && n == 0) {
            if (flowerbed[0] == 1)
                emptySlots++;
        }

        for (int i = 1; i <= flowerbed.length - 1; i++) {

            if (i == 1) {
                // check the first pair {0,0}
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    // there is empty slot
                    emptySlots++;
                    flowerbed[i - 1] = 1;
                }
            } else if (i == flowerbed.length - 1) {
                // Check last pair
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    // there is empty slot
                    emptySlots++;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                emptySlots++;
                flowerbed[i] = 1;
            }
        }

        return emptySlots >= n;
    }


    // LEET 345
    public String reverseVowels(String s) {
        StringBuilder output = new StringBuilder(s);

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < s.length() && !isVowel(s.charAt(start))) {
                start++;
            }
            while (end >= 0 && !isVowel(s.charAt(end))) {
                end--;
            }

            if (start > end) {
                // This will check actual position
                break;
            }
            char temp = output.charAt(end);
            output.setCharAt(end, output.charAt(start));
            output.setCharAt(start, temp);
            start++;
            end--;
        }

        return output.toString();
    }

    private boolean isVowel(Character c) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        map.put('A', 1);
        map.put('E', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('U', 1);
        return map.containsKey(c);
    }

    // LEET 151
    public String reverseWords(String s) {

        Stack<String> wordsStack = new Stack<>();

        String[] words = s.split(" ");

        StringBuilder output = new StringBuilder();
        for (String word : words) {
            if (word.isEmpty()) continue;
            wordsStack.push(word);
        }

        while (!wordsStack.isEmpty()) {
            output.append(wordsStack.pop()).append(" ");
        }
        return output.toString().trim();
    }

    // LEET 238

    public int[] productExceptSelf(int[] nums) {

        int sum = 1;
        int zeros = 0;
        int[] product = new int[nums.length];
        for (int num : nums) {
            if (num == 0) {
                zeros++;
                continue;
            }
            sum *= num;
        }

        if (zeros > 1) return product;

        for (int i = 0; i < nums.length; i++) {
            if (zeros == 1) {
                if (nums[i] == 0) {
                    product[i] = sum;
                } else {
                    product[i] = 0;
                }
                continue;
            }
            product[i] = sum / nums[i];
        }

        return product;
    }

    // 334
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;  // update the smallest value
            } else if (num <= second) {
                second = num;  // update the second smallest value
            } else {
                return true;  // found a triplet: first < second < num
            }
        }

        return false;
    }

    // 392
    public boolean isSubsequence(String s, String t) {
        char[] chars = t.toCharArray();

        int si = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(si) == chars[i]) {
                si++;
            }
        }

        return si == s.length();
    }

    //  443
    public int compress(char[] chars) {
        int counter = 1;
        if (chars.length == 1) return 1;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length -1){
                if (chars[i] == chars[i -1]){
                    output.append(chars[i]);
                    output.append(counter);
                }else {
                    output.append(chars[i]);
                }
                continue;
            }
            if (chars[i] == chars[i + 1]) {
                counter++;
            } else {
                output.append(chars[i]);
                if (counter != 1) {
                    output.append(counter);
                }
                // reset the counter
                counter = 1;
            }
        }
        System.arraycopy(output.toString().toCharArray(), 0, chars, 0, output.length());
        for (int i = output.length(); i < chars.length; i++) {
            chars[i] = '\0'; // or any default value indicating "removed"
        }
        System.out.println(chars);
        return output.length();
    }

    public int maxProfit(int[] prices) {
        // [1,2,3,4,5]
        // [7,1,5,3,6,4]

        int min = prices[0]; // 1
        int max = 0;
        int sum = 0;

        for(int i = 1 ; i < prices.length -1; i++){
            if(min <= prices[i]){
                min = prices[i];
            }else {
                max = Math.max(max, prices[i]);
                if (prices[i] < max){
                    sum += max - min;
                    min = prices[i];
                    max = 0;
                }
            }
        }

        return sum;
    }

//    public void rotate(int[] nums, int k) {
//        // Rotate the array right by k steps
//        for(int i = 0 ; i < k; i++){
//            int last = nums[nums.length - 1];
//            for (int j = nums.length - 1; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = last;
//        }
//
//    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle cases where k is greater than the array length

        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining n - k elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public int singleNumber(int[] nums) {
        int num = 0;

        for(int i = 0 ; i < nums.length; i++){
            num = num ^ nums[i];
        }

        return num;
    }

    public int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        int carry = (digits[lastIndex] + 1) / 10;

        if (carry != 1){
            digits [digits.length - 1] = digits [digits.length - 1] + 1;
            return digits;
        }else{
            // [9,9,9,9] -> [2, 0, 0, 0]
            int lastIndexOf9 = lastIndex;
            while (lastIndexOf9 > 0){
                if (digits[lastIndexOf9] == 9){
                    lastIndexOf9 --;
                }else {
                    break;
                }
            }

            if (lastIndexOf9 == 0 && digits[lastIndexOf9] == 9){
                // When all the digits are 9
                int [] result = new int[digits.length + 1];
                result[0] = 1;
                for (int i = 1 ; i < result.length ; i++){
                    // fill the array with zeros
                    result[i] = 0;
                }
                return result;
            }else{
                digits[lastIndexOf9] = digits[lastIndexOf9] + 1;
                for (int i = lastIndexOf9 + 1; i < digits.length ; i++){
                    digits[i] = 0;
                }
                return digits;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.mergeAlternately("abcd", "pq"));
//        System.out.println(solution.canPlaceFlowers(new int[]{1, 0}, 0));
//        System.out.println(solution.reverseVowels(".,"));
//        System.out.println(solution.reverseWords("The sky  is blue"));
//        System.out.println(solution.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
//        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
//        char[] input = new char[]{'a','a','b','b','c','c','c'};
//        System.out.println(solution.compress(input));
//        System.out.println(input);
//        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        int [] input = new int[]{9};
//        solution.rotate(input, 4);
//        System.out.println(solution.singleNumber(input));
//        for (int n: input){
//            System.out.print(n + " ");
//        }

        int[] result = solution.plusOne(input);
        for (int i: result){
            System.out.print(i + " ");
        }
    }
}
