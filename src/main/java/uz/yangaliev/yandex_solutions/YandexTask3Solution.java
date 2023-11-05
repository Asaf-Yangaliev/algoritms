package uz.yangaliev.yandex_solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class YandexTask3Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int length1 = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            StringTokenizer st1 = new StringTokenizer(line != null ? line : "");
            int length2 = Integer.parseInt(reader.readLine());
            line = reader.readLine();
            StringTokenizer st2 = new StringTokenizer(line != null ? line : "");
            int[] result = new int[length1 + length2];
            int MAX = Integer.MAX_VALUE;
            int current1 = st1.hasMoreTokens() ? Integer.parseInt(st1.nextToken()) : MAX;
            int current2 = st2.hasMoreTokens() ? Integer.parseInt(st2.nextToken()) : MAX;
            int i = 0;
            while (i < length1 + length2) {
                if (current1 <= current2) {
                    result[i] = current1;
                    current1 = st1.hasMoreTokens() ? Integer.parseInt(st1.nextToken()) : MAX;
                } else {
                    result[i] = current2;
                    current2 = st2.hasMoreTokens() ? Integer.parseInt(st2.nextToken()) : MAX;
                }
                i++;
            }
            try (PrintWriter pw = new PrintWriter(System.out)) {
                for (int number : result) {
                    pw.print(number + " ");
                }
            }
        }
    }
}