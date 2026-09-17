package dsa.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    private CheckPermutation() {}

    // time O(nlogn), space O(n)
    public static boolean checkPermutationSortIterate(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }

        return true;
    }

    // time O(nlogn), space O(n)
    public static boolean checkPermutationSortHelper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        return sort(s).equals(sort(t));
    }

    public static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // time O(n), space O(1)
    public static boolean checkPermutationFreqCounter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] letters = new int[128];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int value = t.charAt(i);

            letters[value]--;

            if (letters[value] < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkPermutationHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> letters = new HashMap<>();

        for (char letter : s.toCharArray()) {
            letters.put(letter, letters.getOrDefault(letter, 0) + 1);
        }    

        for (char letter : t.toCharArray()) {
            letters.put(letter, letters.getOrDefault(letter, 0) - 1);
            if (letters.get(letter) < 0) {
                return false;
            }
        }  

        return true;
    }
}