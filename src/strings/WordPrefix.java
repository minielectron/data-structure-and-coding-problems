package strings;

import java.util.Arrays;
import java.util.Comparator;

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

}
