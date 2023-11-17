package uz.yangaliev.yandex.season4.lecture2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class YandexTask3Solution {
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
            try (PrintWriter pw = new PrintWriter(System.out)) {
                pw.print(0);
                pw.print(' ');
                int length = s.length() - 1;
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) == s.charAt(0)) {
                        pw.print(getEqualLength2(helper, s, i, 0, length));
                    } else {
                        pw.print(0);
                    }
                    pw.print(' ');
                    length--;
                }
            }
        }
    }

    private static int getEqualLength2(Helper helper, String s,
                                      int from1, int from2, int length) {
        if (length == 1) {
            return s.charAt(from1) == s.charAt(from2) ? 1 : 0;
        }
        int middleIndex1 = (from1 + from1 + length - 1) / 2;
        int middleIndex2 = (from2 + from2 + length - 1) / 2;
        int l = middleIndex1 - from1 + 1;
        boolean firstPartsAreEqual = compareHashes(helper.hashes, helper.xDegrees, from1, from2, l);
        if (firstPartsAreEqual) {
            return l + getEqualLength2(helper, s, middleIndex1 + 1, middleIndex2 + 1, length - l);
        } else {
            return getEqualLength2(helper, s, from1, from2, length - l);
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
