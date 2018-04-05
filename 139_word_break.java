class Solution {
    public boolean processOneWord(Map<Character, List<String>> dictMap, String s, int head) {
        List<String> strList = dictMap.get(s.charAt(head));
        if (strList == null)
            return false;
        for (int i = 0; i < strList.size(); i++) {
            String word = strList.get(i);
            if (head+word.length() <= s.length() && s.substring(head, head+word.length()).equals(word)) {
                int nextHead = head + word.length();
                if (nextHead == s.length())
                    return true;
                if (processOneWord(dictMap, s, nextHead))
                    return true; 
            }
        }
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> dictMap = new HashMap();
        Set<Character> charSet = new HashSet();
        int head = 0;

        for (String word : wordDict) {
            if (dictMap.get(word.charAt(0)) == null)
                dictMap.put(word.charAt(0), new ArrayList<>());
            dictMap.get(word.charAt(0)).add(word);
            for (Character ch : word.toCharArray())
                charSet.add(ch);
        }

        for (Character ch : s.toCharArray()) 
            if (!charSet.contains(ch))
                return false;

        return processOneWord(dictMap, s, head);
    }
}
// timeout

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet();
        int maxLength = Integer.MIN_VALUE;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
            wordSet.add(word);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; i-j <= maxLength && j >= 0; j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                } 
            }
        }

        return dp[s.length()];
    }
}
