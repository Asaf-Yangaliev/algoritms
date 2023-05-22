package uz.yangaliev.string_functions;

public class LongestSubstringWithoutRepeatingLetters {

    public static int longestSubstringLengthWithoutRepeatingLetters(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int beginResult = 0;
        int endResult = 0;
        boolean[] chars = new boolean[128];
        for (int begin = 0, end = 0; end < s.length(); end++) {
            char sym = s.charAt(end);
            if (chars[sym]) {
                while (s.charAt(begin) != sym) {
                    chars[s.charAt(begin)] = false;
                    begin++;
                }
                begin++;
            } else {
                chars[sym] = true;
                if (end - begin > endResult - beginResult) {
                    beginResult = begin;
                    endResult = end;
                }
            }
        }
        return endResult - beginResult + 1;
    }
}
