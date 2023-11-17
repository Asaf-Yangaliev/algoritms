package uz.yangaliev.yandex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uz.yangaliev.yandex.season4.lecture1.YandexTask4Solution;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class YandexTask4SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void yandexTask3SolutionTest(int[] array, int[] expected) {
        YandexTask4Solution.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 5, 2, 4, 3},
                        new int[]{1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{4, 8, 10, 16, 17, 14, 14, 1, 20, 10},
                        new int[]{1, 4, 8, 10, 10, 14, 14, 16, 17, 20}

                ),
                Arguments.of(
                        new int[]{1, 5, 2, 4, 3, 2, 10, 9, 0, 3},
                        new int[]{0, 1, 2, 2, 3, 3, 4, 5, 9, 10}
                        ),
                Arguments.of(
                        new int[]{4, 2, 3, 1, 7, 9, 8, 18, 14, 12},
                        new int[]{1, 2, 3, 4, 7, 8, 9, 12, 14, 18}
                )
        );
    }
}