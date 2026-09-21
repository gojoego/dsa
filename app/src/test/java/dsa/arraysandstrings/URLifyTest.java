package dsa.arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: finish writing tests
class URLifyTest {
    private void assertAllSolutions(String expected, String input, int trueLength) {
        assertEquals(
            expected, 
            URLify.urlifyBackward(input, trueLength),
            "backward iteration solution"
        );
        assertEquals(
            expected, 
            URLify.urlifyBackward(input, trueLength),
            "backward iteration solution"
        );
    }
}