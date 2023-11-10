package uz.yangaliev.yandex_solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class YandexTask3SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void yandexTask3SolutionTest(YandexTask3TestArguments arguments) {
        YandexTask3Solution.mergeArrays(
                arguments.array1,
                arguments.firstBegin,
                arguments.firstEnd,
                arguments.array2,
                arguments.secondBegin,
                arguments.secondEnd,
                arguments.result,
                arguments.resultBegin
        );
        Assertions.assertArrayEquals(arguments.result, arguments.resultTest);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new YandexTask3TestArguments(
                                new int[]{10, 20, 30, 40, 50},
                                1,
                                3,
                                new int[]{22, 25, 32, 45},
                                1,
                                2,
                                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0},
                                1,
                                new int[]{0, 20, 25, 30, 32, 40, 0, 0, 0}
                        )
                )
        );
    }

    static class YandexTask3TestArguments {
        int[] array1;
        int firstBegin;
        int firstEnd;
        int[] array2;
        int secondBegin;
        int secondEnd;
        int[] result;
        int resultBegin;
        int[] resultTest;

        public YandexTask3TestArguments(int[] array1, int firstBegin, int firstEnd,
                                        int[] array2, int secondBegin, int secondEnd,
                                        int[] result, int resultBegin,
                                        int[] resultTest) {
            this.array1 = array1;
            this.firstBegin = firstBegin;
            this.firstEnd = firstEnd;
            this.array2 = array2;
            this.secondBegin = secondBegin;
            this.secondEnd = secondEnd;
            this.result = result;
            this.resultBegin = resultBegin;
            this.resultTest = resultTest;
        }
    }
}