package uz.yangaliev.yandex.season4.lecture2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class YandexTask4Solution {
    private static long X;
    private static final long P = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] numbers = reader.readLine().split(" ");
            int count = Integer.parseInt(numbers[0]);
            if (count == 0) {
                System.out.println();
                return;
            }
            X = Integer.parseInt(numbers[1]) + 1;
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int[] array1 = new int[count];
            int[] array2 = new int[count];
            for (int i = 0; i < count; i++) {
                int current = Integer.parseInt(st.nextToken());
                array1[i] = current;
                array2[count - i - 1] = current;
            }
            Helper helper1 = calculateHashes(array1);
            Helper helper2 = calculateHashes(array2);

            for (int i = array1.length / 2 - 1; i >= 0 ; i--) {
                if (compareHashes(helper1.hashes, helper1.xDegrees, 0,
                        helper2.hashes, helper2.xDegrees, array1.length - (i * 2 + 1) - 1, i + 1)) {
                    System.out.printf("%d ", count - i - 1);
                }
            }
            System.out.print(count);
        }
    }

    private static Helper calculateHashes(int[] array) {
        long[] xDegrees = new long[array.length + 1];
        xDegrees[0] = 1;
        long[] hashes = new long[array.length + 1];
        for (int i = 1; i <= array.length; i++) {
            hashes[i] = (hashes[i - 1] * X + array[i - 1]) % P;
            xDegrees[i] = (X * xDegrees[i - 1]) % P ;
        }
        return new Helper(hashes, xDegrees);
    }

    private static boolean compareHashes(long[] hashes1, long[] xDegrees1, int from1,
                                         long[] hashes2, long[] xDegrees2, int from2,
                                         int length) {
        return getCompareCriteria(hashes1, xDegrees1, from1, hashes2, xDegrees2, from2, length) ==
                getCompareCriteria(hashes2, xDegrees2, from2, hashes1, xDegrees1, from1, length);
    }

    private static long getCompareCriteria(long[] hashes1, long[] xDegrees1, int from1,
                                           long[] hashes2, long[] xDegrees2, int from2,
                                           int length) {
        from1++;
        from2++;
        return (hashes1[from1 + length - 1] + hashes2[from2 - 1] * xDegrees2[length]) % P;
    }

    private static class Helper {
        long[] hashes;
        long[] xDegrees;

        public Helper(long[] hashes, long[] xDegrees) {
            this.hashes = hashes;
            this.xDegrees = xDegrees;
        }
    }
}
