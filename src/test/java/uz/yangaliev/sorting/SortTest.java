package uz.yangaliev.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uz.yangaliev.yandex_solutions.YandexTask2Solution;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    @ParameterizedTest
    @MethodSource("arguments")
    public void longestSubstringLengthWithoutRepeatingLettersTest(int[] numbers, int[] sorted) {
        YandexTask2Solution.quickSort(numbers);
        assertArrayEquals(numbers, sorted);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 2, 4, 3}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{5, 1}, new int[]{1, 5}),
                Arguments.of(new int[]{16, 10, 17, 8, 4, 14, 14, 1, 20, 10}, new int[]{1, 4, 8, 10, 10, 14, 14, 16, 17, 20}),
                Arguments.of(new int[]{10}, new int[]{10}),
                Arguments.of(new int[]{3, 3, 3, 3}, new int[]{3, 3, 3, 3}),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2, 5, 5, 5, 5, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5})
        );
    }
}