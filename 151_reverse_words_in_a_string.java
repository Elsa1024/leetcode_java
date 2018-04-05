public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        s = s.trim().replaceAll(" +", " ");
        String[] words = s.split(" ");
        int length = words.length;
        StringBuilder sb = new StringBuilder();
        int i = length - 1;
        for (; i > 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[i]);
        return sb.toString();
    }
}

