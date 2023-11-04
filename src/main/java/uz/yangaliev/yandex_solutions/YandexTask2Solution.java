package uz.yangaliev.yandex_solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.function.Predicate;

public class YandexTask2Solution {

    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int count = Integer.parseInt(reader.readLine());
            if (count == 0) {
                return;
            }
            int[] numbers = new int[count];
            int beginIndex = 0;
            String numbersLine = reader.readLine();
            for (int i = 0; i < count; i++) {
                int endIndex = numbersLine.indexOf(' ', beginIndex);
                numbers[i] = endIndex != -1 ? Integer.parseInt(numbersLine.substring(beginIndex, endIndex)):
                        Integer.parseInt(numbersLine.substring(beginIndex));
                beginIndex = endIndex + 1;
            }
            quickSort(numbers);
            System.out.print(numbers[0]);
            for (int i = 1; i < numbers.length; i++) {
                System.out.printf(" %d", numbers[i]);
            }
        }
    }

    public static void quickSort(int[] numbers) {
        quickSortInner(numbers, 0, numbers.length);
    }

    private static void quickSortInner(int[] numbers, int begin, int end) {
        if (end - begin == 1) {
            return;
        }
        int pivot = getRandomElement(numbers, begin, end);
        int less = partition((a) -> a < pivot, numbers, begin, end);
        int equal = partition((a) -> a == pivot, numbers, less, end);
        if (less - begin > 1) {
            quickSortInner(numbers, begin, less);
        }
        if (end - equal > 1) {
            quickSortInner(numbers, equal, end);
        }
    }

    private static int partition(Predicate<Integer> predicate, int[] numbers, int begin, int end) {
        int partitionIndex = begin;
        for (int i = begin; i < end; i++) {
            int current = numbers[i];
            if (predicate.test(current)) {
                int old = numbers[partitionIndex];
                numbers[partitionIndex] = numbers[i];
                numbers[i] = old;
                partitionIndex++;
            }
        }
        return partitionIndex;
    }

    private static int getRandomElement(int[] numbers, int from, int to) {
        return numbers[from + random.nextInt(to - from)];
    }
}
