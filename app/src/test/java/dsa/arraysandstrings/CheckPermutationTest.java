package dsa.arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CheckPermutationTest {
    private void assertAllSolutions(boolean expected, String s, String t) {
        assertEquals(
            expected, 
            CheckPermutation.checkPermutationSortIterate(s, t), 
            "sort and iterate solution failed"
        );
        assertEquals(
            expected, 
            CheckPermutation.checkPermutationSortHelper(s, t), 
            "sort helper solution failed"
        );
            assertEquals(
            expected, 
            CheckPermutation.checkPermutationFreqCounter(s, t), 
            "frequency counter solution failed"
        );
            assertEquals(
            expected, 
            CheckPermutation.checkPermutationHashMap(s, t), 
            "hash table solution failed"
        );
    }

    @ParameterizedTest
    @CsvSource({
        "true,  abcdef,  facedb",
        "false, abcdef,  facedd",
        "false, abcdef,  abcdefg",
        "true,  aab,     aba",
        "false, aab,     abb",
        "true, '', ''"      
    })
    void checksWhetherStringsArePermutations(
        boolean expected,
        String s, 
        String t
    ) {
        assertAllSolutions(expected, s, t);
    }

    @Test 
    void returnsTrueWhenInputsArePermutations() {
        String s = "abcdef";
        String t = "facedb";

        assertAllSolutions(true, s, t);
    } 
}