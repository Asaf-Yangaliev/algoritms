package uz.yangaliev.string_functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static uz.yangaliev.string_functions.SmilesErasure.erasureSmiles;

public class SmilesErasureTest {

    @Test
    void erasureSmilesNullStringTest() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> erasureSmiles(null));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void erasureSmilesTest(String input, String expected) {
        Assertions.assertEquals(expected, erasureSmiles(input));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("hello:-)", "hello"),
                Arguments.of(":-)", ""),
                Arguments.of("bad day:-(((", "bad day"),
                Arguments.of(":-))))hello", "hello"),
                Arguments.of(":-))))):-((((:-))))))", ""),
                Arguments.of(":-(((hello:-)))):-((((:-))))", "hello"),
                Arguments.of(":-))):-(((", ""),
                Arguments.of("my:-))name:-(((is:-(((", "mynameis"),
                Arguments.of("hello:-))))(((", "hello((("),
                Arguments.of(":-)))((((:-))))", "((((")
        );
    }
}
