package datastructure.hashtables;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class NearestRepeatedIndex {
    public int distanceOfClosestRepeatedEntries(String[] sentence) {

        Map<String, Integer> words = new Hashtable<>();
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < sentence.length; i++) {
            if (words.containsKey(sentence[i])) {
                var index = words.get(sentence[i]);
                if (closest > i - index)
                    closest = i - index;
            }
            words.put(sentence[i], i);
        }
        return closest == Integer.MAX_VALUE ? -1 : closest;
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
