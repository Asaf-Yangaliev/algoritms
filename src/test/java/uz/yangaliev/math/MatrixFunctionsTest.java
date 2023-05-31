package uz.yangaliev.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static uz.yangaliev.math.MatrixFunctions.determinant;

public class MatrixFunctionsTest {

    @ParameterizedTest
    @MethodSource("negativeArguments")
    public void negativeArgumentsTest(int[][] matrix) {
        assertThrows(IllegalArgumentException.class,
                () -> determinant(matrix));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void determinantTest(int[][] matrix, int expected) {
        assertEquals(expected, determinant(matrix));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1}
                                },
                        1
                ),
                Arguments.of(
                        new int[][]{
                                {7}
                                },
                        7
                ),
                Arguments.of(
                        new int[][]{
                                {1, 4},
                                {4, 9}
                                },
                        -7
                ),
                Arguments.of(
                        new int[][]{
                                {5, 2},
                                {8, -6}
                        },
                        -46
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9},
                        },
                        0
                ),
                Arguments.of(
                        new int[][]{
                                {5, 8, -4},
                                {2, 14, 16},
                                {9, 4, 1}
                        },
                        1358
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        0
                ),
                Arguments.of(
                        new int[][]{
                                {2, 4, 5, -8},
                                {7, 6, -4, 5},
                                {11, 23, -9, 7},
                                {-20, -4, 45, 11}
                        },
                        48303
                )
        );
    }

    static Stream<int[][]> negativeArguments() {
        return Stream.of(
                null,
                new int[][]{
                        {1, 2},
                        {5, 6, 7}
                        },
                new int[][]{
                        {1, 2, 6},
                        {5, 6, 7},
                        {6, 44, 4},
                        {1, 22, 1}
                },
                new int[][]{
                        {}
                }
        );
    }
}
