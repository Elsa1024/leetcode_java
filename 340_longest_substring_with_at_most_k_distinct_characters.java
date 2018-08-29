class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0)
            return 0;
        
        int maxLength = 0, head = 0, counter = 0;
        Set<Character> charSet = new HashSet();
       
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
            if (charSet.size() > k) {
                System.out.println("i: " + i + ", head: " + head);
                maxLength = Math.max(maxLength, i - head);
                charSet.clear();
                charSet.add(s.charAt(i));
                for (head = i - 1; head >= 0; head--) {
                    charSet.add(s.charAt(head));
                    if (charSet.size() > k) {
                        charSet.remove(s.charAt(head));
                        break;
                    }
                }
                head++;
            }         
        }
        
        if (charSet.size() <= k)
            maxLength = Math.max(s.length() - head, maxLength);
        
        return maxLength;
    }
}

/*
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0)
            return 0;
        
        int maxLength = 0, head = 0, counter = 0;
        int[] counters = new int[256];
       
        for (int i = 0; i < s.length(); i++) {
            if (counters[s.charAt(i)]++ == 0)
                counter++;
            if (counter > k) {
                maxLength = Math.max(maxLength, i - head);
                while (--counters[s.charAt(head++)] > 0) ;
                counter--;
            }
        }
        
        if (counter <= k)
            maxLength = Math.max(s.length() - head, maxLength);
        
        return maxLength;
    }
}
*/
