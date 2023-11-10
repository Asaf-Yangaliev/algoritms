package uz.yangaliev.yandex_solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.function.Function;

public class YandexTask5Solution {

    private static final byte ZERO_INDEX = '0';

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int length = Integer.parseInt(reader.readLine());
            if (length == 0) {
                System.out.println();
                return;
            }
            String[] array = new String[length];
            for (int i = 0; i < length; i++) {
                array[i] = reader.readLine();
            }
            try (PrintWriter pw = new PrintWriter(System.out)) {
                beginPrint(pw, array);
                bitwiseSorting(array, pw);
                endPrint(pw, array);
            }
        }
    }

    public static void bitwiseSorting(String[] array, PrintWriter pw) {
        String any = array[0];
        for (int i = 0; i < any.length(); i++) {
            pw.println(String.format("Phase %d", i + 1));
            int j = any.length() - i - 1;
            Function<String, Byte> function = (a) -> (byte) ((byte) a.charAt(j) - ZERO_INDEX);
            innerBitwiseSorting(array, function);
            for (int bucketNumber = 0, current = 0; bucketNumber < array.length; bucketNumber++) {
                pw.print(String.format("Bucket %d: ", bucketNumber));
                if (function.apply(array[current]) != bucketNumber) {
                    pw.println("empty");
                } else {
                    while (current < array.length && function.apply(array[current]) == bucketNumber) {
                        pw.print(array[current]);
                        pw.print(" ");
                        current++;
                    }
                    pw.println();
                }
            }
        }
    }

    private static void innerBitwiseSorting(String[] array, Function<String, Byte> function) {
        int[] counts = new int[10];
        for (String item : array) {
            counts[function.apply(item)]++;
        }
        int[] indexes = new int[10];
        int nextIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                indexes[i] = nextIndex;
                nextIndex += counts[i];
            }
        }
        String[] helper = new String[array.length];
        for (String item : array) {
            byte number = function.apply(item);
            helper[indexes[number]] = item;
            indexes[function.apply(item)]++;
        }
        System.arraycopy(helper, 0, array, 0, helper.length);
    }

    private static void beginPrint(PrintWriter pw, String[] array) {
        pw.println("Initial array:");
        for (String item : array) {
            pw.print(item);
            pw.print(" ");
        }
        pw.println();
        pw.println("**********");
    }

    private static void endPrint(PrintWriter pw, String[] array) {
        pw.println("Sorted array:");
        for (String item : array) {
            pw.print(item);
            pw.print(" ");
        }
    }
}
