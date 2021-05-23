package strings;

import java.util.*;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome p = new LongestPalindrome();
        System.out.println(p.longestPalindrome("aaaaabbbbbyyyyyuuuuukkkkklllllfffffrrrrrwwwwwpppppqqqqqabcdefgh"));
        System.out.println(p.longestPalindromeUsingSet("aaaaabbbbbyyyyyuuuuukkkkklllllfffffrrrrrwwwwwpppppqqqqqabcdefgh"));
    }

    public int longestPalindrome(String s) {
        int size = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Integer> l = new ArrayList<>(map.values());
        l.sort(Collections.reverseOrder());

        boolean oddSeen = false;
        for (int i : l) {
            if (i % 2 == 0) {
                size += i;
            } else {
                if (!oddSeen) {
                    oddSeen = true;
                    size += i;
                } else {
                    size += i - 1;
                }
            }
        }

        return size;
    }

    public int longestPalindromeUsingSet(String s) {
        int size = 0;

        HashSet<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                size += 2;
            } else {
                set.add(c);
            }
        }

        return set.size() == 0 ? size : size + 1;
    }
}
