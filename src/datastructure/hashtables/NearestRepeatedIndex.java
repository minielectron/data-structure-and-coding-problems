package datastructure.hashtables;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class NearestRepeatedIndex {
    public int distanceOfClosestRepeatedEntries(String[] sentence) {

        Map<String, Integer> words = new Hashtable<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < sentence.length; i++) {
            if (words.containsKey(sentence[i])) {
                var index = words.get(sentence[i]);
                output.add(i - index);
            }
            words.put(sentence[i], i);
        }

        if (!output.isEmpty()) {
            int min = output.get(0);
            for (int i = 1; i < output.size(); i++) {
                if (output.get(i) < min) min = output.get(i);
            }
            return min;
        } else return -1;
    }

    public static void main(String[] args) {
        NearestRepeatedIndex ns = new NearestRepeatedIndex();
        String[] input = {
                "This",
                "is",
                "a",
                "sentence",
                "with",
                "is",
                "repeated",
                "then",
                "repeated"
        };
        System.out.println(ns.distanceOfClosestRepeatedEntries(input));
    }
}
