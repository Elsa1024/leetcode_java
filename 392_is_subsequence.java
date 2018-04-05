class Solution {
    public boolean isSubsequence(String s, String t) {
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j < t.length()) {
                if (s.charAt(i) != t.charAt(j))
                    j++;
                else 
                    break;
            }
            if (j < t.length()) {
                j++;
                continue;
            }
            return false;
        }
        return true;
    }
}

/*
class Solution {
    public boolean isSubsequence(String s, String t) {
        for (int i = 0, j = 0; i < s.length(); i++) {
            int index = t.indexOf(String.valueOf(s.charAt(i)), j);
            System.out.println("char: " + s.charAt(i) + ", index: " + index);
            if (index < 0)
                return false;
            else
                j = index + 1;
        }
        return true;
    }
}
*/
