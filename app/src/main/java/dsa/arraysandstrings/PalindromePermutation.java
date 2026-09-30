package dsa.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

// check if string is a permutation of a palindrome 
class PalindromePermutation {
    // palindrome all pairs or all pairs + 1 single letter
    private PalindromePermutation() {}

    // time O(n), space(n)
    public static boolean palindromePermutation(String s) {

        String normalized = s.toLowerCase();
        // hash table 
        Map<Character, Integer> letters = new HashMap<>();

        boolean foundOdd = false;
        
        for (char letter : normalized.toCharArray()) {
            if (letter == ' ') continue;
            letters.put(
                letter, 
                letters.getOrDefault(letter, 0) + 1
            );
        }   

        for (Integer count : letters.values()) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }

                foundOdd = true;
            }
        }
        return true;
    }

    // time O(n), space O(1)
    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table); 
    }

    // check that no more than 1 character has odd count
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    // map each character to number, case-insensitive, non-letter -1
    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int value = Character.getNumericValue(c);
        if (a <= value && value <= z) {
            return value - a;
        }
        return -1;
    }

    // helper function to count how many times each character appears 
    public static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) table[x]++;
        }
        return table;
    }

    // time O(n), space O(1)
    public static boolean palindromePermutationOpt(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            } 
        }    
        return countOdd <= 1;
    }
    
    // toggle ith bit in int
    public static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        bitVector ^= mask;
        return bitVector;
    }

    // create bit vector for string - for each letter value i, toggle ith bit 
    public static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    // check that 1 bit at most set by subtracting 1 from int ANDing w original integer 
    public static boolean checkAtMostOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    // time O(n), space O(1)
    public static boolean palindromePermutationBitVector(String phrase) {
        int bitVector = createBitVector(phrase);
        return checkAtMostOneBitSet(bitVector);
    }
}