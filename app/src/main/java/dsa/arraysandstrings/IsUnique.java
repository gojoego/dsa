package dsa.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class IsUnique {
    
    private IsUnique() {}

    // time O(n^2), space O(1) 
    public static boolean isUniqueBruteForce(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }                
            }
        }
        return true;
    }

    // time O(n), space O(n)
    public static boolean isUniqueHashMap(String str) {
        Map<Character, Boolean> characters = new HashMap<>();

        for (char letter : str.toCharArray()) {
            if (characters.containsKey(letter)) {
                return false;
            } 
            characters.put(letter, true);

        }
        return true;
    }

    // time O(n), space O(1)
    public static boolean isUniqueBitVector(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'a';
            
            if (((checker & (1 << value)) > 0)) {
                return false;
            }
            checker |= (1 << value);
        }
        return true;
    }

    // time O(nlogn), space O(n)
    public static boolean isUniqueSort(String str) {
        char[] letters = str.toCharArray();

        Arrays.sort(letters);

        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == letters[i - 1]) {
                return false;
            }
        }

        return true;
    }

    // time O(n), space O()
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            if (charSet[value]) return false;
            charSet[value] = true;
        }
        return true;
    }
}