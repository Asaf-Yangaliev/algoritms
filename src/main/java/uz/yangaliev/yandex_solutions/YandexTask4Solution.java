package uz.yangaliev.yandex_solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class YandexTask4Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int length = Integer.parseInt(reader.readLine());
            if (length == 0) {
                System.out.println();
            }
            String line = reader.readLine();
            StringTokenizer st1 = new StringTokenizer(line);
            int[] array = new int[length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(st1.nextToken());
            }
            mergeSort(array);
            try (PrintWriter pw = new PrintWriter(System.out)) {
                for (int item : array) {
                    pw.print(item + " ");
                }
            }
        }
    }

    public static void mergeSort(int[] array) {
        int length = array.length;
        if (length == 0 || length == 1) {
            return;
        }
        int middleIndex = (array.length - 1) / 2;
        int[] helper = new int[array.length];
        System.arraycopy(array, 0, helper, 0, array.length);

        innerMergeSort(helper,
                0, middleIndex,
                middleIndex + 1, array.length - 1,
                array);
        System.arraycopy(helper, 0, array, 0, helper.length);
    }

    private static void innerMergeSort(int[] helper,
                                       int firstBegin, int firstEnd,
                                       int secondBegin, int secondEnd,
                                       int[] array
                                       ) {
        if (firstBegin != firstEnd) {
            int middleIndex = (firstBegin + firstEnd) / 2;
            innerMergeSort(array,
                    firstBegin, middleIndex,
                    middleIndex + 1, firstEnd,
                    helper);
        }
        if (secondBegin != secondEnd) {
            int middleIndex = (secondBegin + secondEnd) / 2;
            innerMergeSort(array,
                    secondBegin, middleIndex,
                    middleIndex + 1, secondEnd,
                    helper);
        }
        mergeArrays(array, firstBegin, firstEnd,
                array, secondBegin, secondEnd,
                helper, firstBegin
                );
    }

    private static void mergeArrays(int[] array1, int firstBegin, int firstEnd,
                                   int[] array2, int secondBegin, int secondEnd,
                                   int[] result, int resultBegin) {
        int resultLength = firstEnd - firstBegin + 1 + secondEnd - secondBegin + 1;
        int MAX = Integer.MAX_VALUE;
        int i = resultBegin, i1 = firstBegin, i2 = secondBegin;
        int current1 = array1[i1];
        int current2 = array2[i2];
        while (i < resultBegin + resultLength) {
            if (current1 <= current2) {
                result[i] = current1;
                i1++;
                current1 = i1 <= firstEnd ? array1[i1] : MAX;
            } else {
                result[i] = current2;
                i2++;
                current2 = i2 <= secondEnd ? array2[i2] : MAX;
            }
            i++;
        }
    }
}
