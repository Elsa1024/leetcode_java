class Solution {
    public int validLength(String s, Map<Character, List<Integer>> characterMap, int head, int tail) {
        // System.out.println("head: " + head + ", tail: " + tail);
        if (tail == head)
            return 1;
        for (int i = head; i <= tail; i++) {
            List<Integer> indexList = characterMap.get(s.charAt(i));
            int idx = indexList.indexOf(i);
                // System.out.println("indexList: " + Arrays.toString(indexList.toArray()) + ", idx: " + idx);
            if (idx > -1 && (idx < indexList.size() - 1 && indexList.get(idx+1) <= tail)) {
                // System.out.println("invalid, i: " + i);
                return validLength(s, characterMap, head, indexList.get(idx+1)-1);
            }
        }
        return tail-head+1;
    }
    
    public int lengthOfLongestSubstring(String s) {
        int maxLength = -1;
        if (s == null || s.length() == 0)
            maxLength = 0;
        
        Map<Character, List<Integer>> characterMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (characterMap.get(ch) == null)
                characterMap.put(ch, new ArrayList<>());
            characterMap.get(ch).add(i);
        }

        for (int i = 0; i < s.length(); i++) 
            maxLength = Math.max(maxLength, validLength(s, characterMap, i, s.length() - 1));
        
        return maxLength;
    }
}
// timeout

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
