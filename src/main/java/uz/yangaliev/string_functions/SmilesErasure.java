package uz.yangaliev.string_functions;

public class SmilesErasure {
    public static String erasureSmiles(String s) {
        if (s == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        StringBuilder result = new StringBuilder();
        int begin = 0;
        while (true) {
            int index = minIndex(s.indexOf(":-)", begin), s.indexOf(":-(", begin));
            if (index == -1) {
                result.append(s, begin, s.length());
                break;
            } else {
                result.append(s, begin, index);
                char bracket = s.charAt(index + 2);
                begin = index + 3;
                while (begin < s.length() && s.charAt(begin) == bracket) {
                    begin++;
                }
            }
        }
        return result.toString();
    }

    private static int minIndex(int i, int j) {
        if (i == -1 && j == -1)
            return -1;
        else if (i == -1)
            return j;
        else if (j == -1)
            return i;
        else
            return Math.min(i, j);
    }
}
