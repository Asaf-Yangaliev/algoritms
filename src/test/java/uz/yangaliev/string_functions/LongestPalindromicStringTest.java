package uz.yangaliev.string_functions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uz.yangaliev.string_functions.LongestPalindromicString.longestPalindrome;

public class LongestPalindromicStringTest {

    @ParameterizedTest
    @MethodSource("arguments")
    public void longestSubstringLengthWithoutRepeatingLettersTest(String s, String expected) {
        assertEquals(expected, longestPalindrome(s));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("b", "b"),
                Arguments.of("abcdefg", "a"),
                Arguments.of("babadcbabcbad", "cbabc"),
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb")
        );
    }
}
