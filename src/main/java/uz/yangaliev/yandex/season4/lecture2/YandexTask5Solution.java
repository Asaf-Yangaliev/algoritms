package uz.yangaliev.yandex.season4.lecture2;

import java.io.BufferedReader;
import java.io.FileReader;

public class YandexTask5Solution {

    private static final long X = 257;
    private static final long P = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            int result = line.length();
            String reverse = new StringBuilder(line).reverse().toString();
            Helper helper1 = calculateHashes(line);
            Helper helper2 = calculateHashes(reverse);
            for (int len = 2; len <= line.length(); len++) {
                for (int i = 0; i <= line.length() - len ; i++) {
                    if (compareHashes(helper1.hashes, helper1.xDegrees, i, helper2.hashes, helper2.xDegrees,
                            line.length() - i - len, len)) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static Helper calculateHashes(String s) {
        long[] xDegrees = new long[s.length() + 1];
        xDegrees[0] = 1;
        long[] hashes = new long[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            hashes[i] = (hashes[i - 1] * X + getLong(s.charAt(i - 1))) % P;
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
