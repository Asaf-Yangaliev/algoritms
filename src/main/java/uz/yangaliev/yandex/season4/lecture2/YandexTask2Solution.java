package uz.yangaliev.yandex.season4.lecture2;

import java.io.BufferedReader;
import java.io.FileReader;

public class YandexTask2Solution {
    private static final long X = 257;
    private static final long P = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String s = reader.readLine();
            if (s == null || s.length() == 0) {
                System.out.println(0);
                return;
            }
            Helper helper = calculateHashes(s);
            int delta = 1;
            int length = s.length() - 1;
            while (length > 0) {
                if (compareHashes(helper.hashes, helper.xDegrees,
                        0, delta, length)) {
                    System.out.println(delta);
                    return;
                }
                delta++;
                length--;
            }
            System.out.println(s.length());
        }
    }

    private static boolean compareHashes(long[] hashes, long[] xDegrees,
                                         int from1, int from2, int length) {
        return getCompareCriteria(hashes, xDegrees, from1, from2, length) ==
                getCompareCriteria(hashes, xDegrees, from2, from1, length);
    }

    private static Helper calculateHashes(String s) {
        long[] xDegrees = new long[s.length() + 1];
        xDegrees[0] = 1;
        long[] hashes = new long[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            hashes[i] = (hashes[i - 1] * X + getLong(s.charAt(i - 1))) % P;
            xDegrees[i] = (X * xDegrees[i - 1]) % P;
        }
        return new Helper(hashes, xDegrees);
    }

    private static long getCompareCriteria(long[] hashes, long[] xDegrees,
                                           int from1, int from2, int length) {
        from1++;
        from2++;
        return (hashes[from1 + length - 1] + hashes[from2 - 1] * xDegrees[length]) % P;
    }

    private static long getLong(char ch) {
        return ch - 'a';
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
