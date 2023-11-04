package uz.yangaliev.string_functions;



public class LongestPalindromicString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babadcbabcbad"));
    }

    public static String longestPalindrome(String s) {
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            int next = i + 1;
            while (next < s.length() && (next = s.indexOf(symbol, next)) != -1) {
                if ((next - i + 1) > (endIndex - beginIndex + 1) && isPalindrome(i, next, s)) {
                    beginIndex = i;
                    endIndex = next;
                }
                next++;
            }
        }
        return s.substring(beginIndex, endIndex + 1);
    }

    private static boolean isPalindrome(int begin, int end, String s) {
        for (int i = 0; i <= (end - begin + 1) / 2; i++) {
            if (s.charAt(begin + i) != s.charAt(end - i))
                return false;
        }
        return true;
    }
}
