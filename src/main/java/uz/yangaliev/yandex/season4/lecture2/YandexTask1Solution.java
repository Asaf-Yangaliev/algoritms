package uz.yangaliev.yandex.season4.lecture2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class YandexTask1Solution {

    private static final long X = 257;
    private static final long P = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String string = reader.readLine();
            int count = Integer.parseInt(reader.readLine());
            if (count == 0) {
                System.out.println();
            }
            Helper helper = calculateHashes(string);
            for (int i = 0; i < count; i++) {
                String line = reader.readLine();
                StringTokenizer st = new StringTokenizer(line);
                int l = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (a != b) {
                    if (compareHashes(helper.hashes, helper.xDegrees, a, b, l)) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }

                } else {
                    System.out.println("yes");
                }
            }

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

    private static boolean compareHashes(long[] hashes, long[] xDegrees,
                                         int from1, int from2, int length
                                ) {
        return getCompareCriteria(hashes, xDegrees, from1, from2, length) ==
                getCompareCriteria(hashes, xDegrees, from2, from1, length);
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
