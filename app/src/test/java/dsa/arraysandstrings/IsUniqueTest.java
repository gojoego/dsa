package dsa.arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class IsUniqueTest {
    
    private void assertAllSolutions(boolean expected, String input) {
        assertEquals(
            expected, 
            IsUnique.isUniqueBruteForce(input),
            "brute force solution failed"
        );
        assertEquals(
            expected, 
            IsUnique.isUniqueHashMap(input),
            "hashmap solution failed"
        );        
        assertEquals(
            expected, 
            IsUnique.isUniqueBitVector(input),
            "bit vector solution failed"
        ); 
        assertEquals(
            expected, 
            IsUnique.isUniqueSort(input),
            "sorting solution failed"
        );
        assertEquals(
            expected, 
            IsUnique.isUniqueChars(input),
            "boolean array solution failed"
        );       
    }

    @Test 
    void returnsTrueWhenAllCharactersUnique() {
        String allUnique = "abcdefgh";

        assertAllSolutions(true, allUnique);
    }

    @Test 
    void returnsFalseWhenAllCharactersAreNotUnique() {
        String duplicates = "aabbccdd";

        assertAllSolutions(false, duplicates);
    }

    @Test 
    void returnsTrueForEmptyString() {
        String empty = "";

        assertAllSolutions(true, empty);
    }

    @Test 
    void returnsTrueForOneCharacter() {
        String single = "a";

        assertAllSolutions(true, single);
    }

    @Test 
    void returnsFalseDuplicatesAreFarApart() {
        String farApart = "abcdefghijklmnopqrstuvwxyza";

        assertAllSolutions(false, farApart);
    }
}