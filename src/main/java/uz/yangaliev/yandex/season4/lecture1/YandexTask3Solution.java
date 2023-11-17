package uz.yangaliev.yandex.season4.lecture1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class YandexTask3Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int length1 = Integer.parseInt(reader.readLine());
            String line1 = reader.readLine();
            int length2 = Integer.parseInt(reader.readLine());
            String line2 = reader.readLine();
            if (length1 == 0 || length2 == 0) {
                if (length1 == 0 && length2 == 0) {
                    System.out.println();
                    return;
                } else if (length1 == 0) {
                    System.out.println(line2);
                } else {
                    System.out.println(line1);
                }
                return;
            }
            StringTokenizer st1 = new StringTokenizer(line1 != null ? line1 : "");
            StringTokenizer st2 = new StringTokenizer(line2 != null ? line2 : "");
            int[] result = new int[length1 + length2];
            int[] array1 = new int[length1];
            int[] array2 = new int[length2];
            for (int i = 0; i < array1.length; i++) {
                array1[i] = Integer.parseInt(st1.nextToken());
            }
            for (int i = 0; i < array2.length; i++) {
                array2[i] = Integer.parseInt(st2.nextToken());

            }
            mergeArrays(array1, 0, array1.length - 1,
                    array2, 0, array2.length - 1,
                    result, 0);
            try (PrintWriter pw = new PrintWriter(System.out)) {
                for (int item : result) {
                    pw.print(item + " ");
                }
            }
        }
    }

    public static void mergeArrays(int[] array1, int firstBegin, int firstEnd,
                                   int[] array2, int secondBegin, int secondEnd,
                                   int[] result, int resultBegin) {
        int resultLength = firstEnd - firstBegin + 1 + secondEnd - secondBegin + 1;
        int MAX = Integer.MAX_VALUE;
        int i = resultBegin, i1 = firstBegin, i2 = secondBegin;
        int current1 = array1[i1];
        int current2 = array2[i2];
        while (i < resultLength) {
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