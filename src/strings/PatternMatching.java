package strings;

import java.util.ArrayList;
import java.util.HashMap;

public class PatternMatching {

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        words.add("aac");
        words.add("bbc");
        words.add("cbb");
        words.add("yzy");

        String pattern = "ghg";
        String hash = encodeString(pattern);
        ArrayList<String> matches = new ArrayList<>();
        for (String word : words) {
            if (hash.equals(encodeString(word))) {
                matches.add(word);
            }
        }

        System.out.println(matches);
    }

    public static String encodeString(String word) {
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        int code = 0;
        char ch;

        for (int i = 0; i < word.length(); i++) {

            ch = word.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, code++);
            }

            res.append(map.get(ch));
        }

        return res.toString();
    }
}
