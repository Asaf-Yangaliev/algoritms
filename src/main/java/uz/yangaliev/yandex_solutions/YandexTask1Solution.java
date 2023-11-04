package uz.yangaliev.yandex_solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.function.Predicate;

public class YandexTask1Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int count = Integer.parseInt(reader.readLine());
            if (count == 0) {
                System.out.println(0);
                System.out.println(0);
                return;
            }
            int[] numbers = new int[count];
            int beginIndex = 0;
            String numbersLine = reader.readLine();
            for (int i = 0; i < count; i++) {
                int endIndex = numbersLine.indexOf(' ', beginIndex);
                numbers[i] = endIndex != -1 ? Integer.parseInt(numbersLine.substring(beginIndex, endIndex)) :
                        Integer.parseInt(numbersLine.substring(beginIndex));
                beginIndex = endIndex + 1;
            }
            int x = Integer.parseInt(reader.readLine());
            int result = partition((a) -> a < x, numbers, 0, count);
            System.out.println(result);
            System.out.println(numbers.length - result);
        }
    }

    public static int partition(Predicate<Integer> predicate, int[] numbers, int begin, int end) {
        int index = begin;
        for (int i = begin; i < end; i++) {
            int current = numbers[i];
            if (predicate.test(current)) {
                int old = numbers[index];
                numbers[index] = numbers[i];
                numbers[i] = old;
                index++;
            }
        }
        return index;
    }
}
