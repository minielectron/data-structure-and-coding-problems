package udemyds.arrays;

import java.util.Arrays;

// An anagram phrase or word formed by rearranging the letters of a
// different word or phrase - using all the original letters exactly once
public class AnagramProblem {

    public boolean checkIfAnagrams(char[] subject, char[] input) {

        if (subject.length != input.length) return false;

        Arrays.sort(subject); // NLogN
        Arrays.sort(input);

        for (int i = 0; i < subject.length; i++) {
            if (subject[i] != input[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AnagramProblem anagramProblem = new AnagramProblem();
        boolean isAnagram = anagramProblem.checkIfAnagrams(new char[]{'f', 'l', 'u', 's', 't', 'e', 'r'}, new char[]{'r', 'e', 's', 't', 'f', 'u', 'l'});
        System.out.println(isAnagram);
    }
}
