package strings;

import java.util.*;

/*
Given a list of prefixes prefixes and a sentence sentence, replace all words in sentence that start with any of the given prefixes in prefixes.

        Example:
        Inputs:
        prefixes = ["cat", "catch", "Alabama"]
        sentence = "The cats were catching yarn"

        Output: "The cat were cat yarn"
        Explanation: "cats" and "catching" were both replaced by their shortest prefix match "cat"*/
public class WordPrefix {

    public static void main(String[] args) {

        System.out.println(replacePrefix(new String[]{"cat", "catch", "Alabama"},
                "The cat were cat yarn"));
        List<String> A = List.of("padding", "css", "randomcs");
        List<String> B = List.of("cs", "c");
        System.out.println(wordSubsets(A, B));
    }

    public static String replacePrefix(String[] prefixes, String sentence) {

        StringBuilder res = new StringBuilder();

        String[] words = sentence.split(" ");
        Arrays.sort(prefixes, new WordComparator());

        boolean matched = false;

        for (String word : words) {
            for (String prefix : prefixes) {
                if (word.startsWith(prefix)) {
                    res.append(" ").append(prefix);
                    matched = true;
                    break;
                }
            }

            if (matched) {
                matched = false;
            } else {
                res.append(" ").append(word);
            }
        }
        return res.toString().trim();
    }

    static class WordComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    public static ArrayList<String> wordSubsets(List<String> A, List<String> B) {
        ArrayList<String> output = new ArrayList<>();

        // Merge the B into single word.
        String mergedWord = mergeSets(B);

        for (String s : A) {
            if (ifSubset(s, mergedWord)) {
                output.add(s);
            }
        }
        // Iterate and test for each word in A
        System.out.println(mergedWord);
        return output;
    }

    static boolean ifSubset(String superset, String subset) {

        if (superset.length() < subset.length()) return false;

        for (int i = 0; i < subset.length(); i++) {
            var c = subset.charAt(i);
            var actualCount = superset.codePoints().filter(ch -> ch == c).count();
            var expectedCount = subset.codePoints().filter(ch -> ch == c).count();

            if (actualCount < expectedCount) return false;
        }
        return true;
    }

    private static String mergeSets(List<String> b) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : b) {
            for (int i = 0; i < word.length(); i++) {
                String s = String.valueOf(word.charAt(i));
                int count = (int) word.codePoints().filter(ch -> ch == s.charAt(0)).count();
                if (!countMap.containsKey(s)) {
                    countMap.put(s, count);
                } else {
                    countMap.put(s, Math.max(countMap.get(s), count));
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for (var entry : countMap.entrySet()) {
            var key = entry.getKey();
            output.append(key.repeat(countMap.get(key)));
        }
        return output.toString();
    }

}
