class Solution {
    public String extendPalindrome(String s, int head, int tail) {
        // System.out.println("s: " + s + ", head: " + head + ", tail: " + tail);
        while (head > 0 && tail < s.length() - 1) {
            if (s.charAt(head - 1) == s.charAt(tail + 1)) {
                head--;
                tail++;
            } else {
                break;
            }
        }
        return s.substring(head, tail+1);
    }
    
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        if (s != null && s.length() > 0) {
            longestPalindrome = s.substring(0, 1);
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    String palindrome = extendPalindrome(s, i, i+1);
                    if (palindrome.length() > longestPalindrome.length())
                        longestPalindrome = palindrome;
                }
                if (i+2 < s.length() && s.charAt(i) == s.charAt(i+2)) {
                    String palindrome = extendPalindrome(s, i, i+2);
                    if (palindrome.length() > longestPalindrome.length())
                        longestPalindrome = palindrome;
                }
            }
        }
        return longestPalindrome;
    }
}
