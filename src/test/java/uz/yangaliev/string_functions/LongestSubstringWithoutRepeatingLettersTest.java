package uz.yangaliev.string_functions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uz.yangaliev.string_functions.LongestSubstringWithoutRepeatingLetters.longestSubstringLengthWithoutRepeatingLetters;

public class LongestSubstringWithoutRepeatingLettersTest {


    @ParameterizedTest
    @MethodSource("arguments")
    public void longestSubstringLengthWithoutRepeatingLettersTest(String s, int expected) {
        assertEquals(expected, longestSubstringLengthWithoutRepeatingLetters(s));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0),
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("aab", 2),
                Arguments.of("dvdf", 3),
                Arguments.of("tmmzuxt", 5)
        );
    }
}
