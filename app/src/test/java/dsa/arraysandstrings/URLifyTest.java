package dsa.arraysandstrings;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class URLifyTest {
    private void assertBufferedSolutions(
        String expected, 
        String bufferedInput, 
        int trueLength
    ) {
        assertEquals(
            expected, 
            URLify.urlifyBackward(bufferedInput, trueLength),
            "backward traversal solution failed"
        );

        assertEquals(
            expected, 
            URLify.urlify(bufferedInput, trueLength),
            "in-place wrapper solution failed"
        );

        char[] characters = bufferedInput.toCharArray();

        URLify.replaceStrings(characters, trueLength);

        String actual = new String(
            characters, 
            0, 
            expected.length()
        );

        assertEquals(
            expected, 
            actual,
            "direct in-place solution failed"
        );
    }

    private void assertStringBuilderSolution(
        String expected, 
        String input
    ) {
        assertEquals(
            expected, 
            URLify.urlifyStringBuilder(input),
            "StringBuilder solution failed"
        );
    }

    private static Stream<Arguments> urlifyTestCases() {
        return Stream.of(
            Arguments.of(
                "Mr%20John%20Smith",
                "Mr John Smith",
                "Mr John Smith    ",
                13            
            ),
            Arguments.of(
                "Hello",
                "Hello",
                "Hello",
                5
            ),
            Arguments.of(
                "Hello%20World",
                "Hello World",
                "Hello World  ",
                11
            ),
            Arguments.of(
                "a%20%20b",
                "a  b",
                "a  b    ",
                4
            ),
            Arguments.of(
                "%20Hello",
                " Hello",
                " Hello  ",
                6
            ),
            Arguments.of(
                "Hello%20",
                "Hello ",
                "Hello   ",
                6
            ),
            Arguments.of(
                "",
                "",
                "",
                0
            )
        );
    }

    @ParameterizedTest(
        name = "[{index}] urlify \"{1}\" as \"{0}\""
    )
    @MethodSource("urlifyTestCases")
    void replacesSpacesWithPercentTwenty(
        String expected, 
        String input, 
        String bufferedInput, 
        int trueLength
    ) {
        assertBufferedSolutions(expected, bufferedInput, trueLength);
        assertStringBuilderSolution(expected, input);
    }
}