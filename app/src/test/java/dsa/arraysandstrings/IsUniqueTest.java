package dsa.arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class IsUniqueTest {

    @Test 
    void returnsTrueWhenAllCharactersUnique() {
        String allUnique = "abcdefgh";

        boolean unique = IsUnique.isUniqueBruteForce(allUnique);

        assertTrue(unique);
    }

    @Test 
    void returnsFalseWhenAllCharactersNotUnique() {
        String duplicates = "aabbccdd";

        boolean unique = IsUnique.isUniqueBruteForce(duplicates);

        assertFalse(unique);
    }

    @Test 
    void returnsTrueForEmptyString() {
        String empty = "";

        boolean unique = IsUnique.isUniqueBruteForce(empty);

        assertTrue(unique);
    }

    @Test 
    void returnsTrueForOneCharacter() {
        String single = "a";

        boolean unique = IsUnique.isUniqueBruteForce(single);

        assertTrue(unique);
    }

    @Test 
    void returnsFalseDuplicatesFarApart() {
        String farApart = "abcdefghijklmnopqrstuvwxyza";

        boolean unique = IsUnique.isUniqueBruteForce(farApart);

        assertFalse(unique);
    }
}