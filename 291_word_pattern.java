class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> dictionary = new HashMap();
        return isPatternMatched(pattern, 0, str, 0, dictionary);
    }
    
    public boolean isPatternMatched(String pattern, int pIdx, String str, int sIdx, Map<Character, String> dictionary) {
        if (pIdx == pattern.length() && sIdx == str.length())
            return true;
        
        if (pIdx == pattern.length() || sIdx == str.length())
            return false;
        
        char ch = pattern.charAt(pIdx);
        if (dictionary.get(ch) != null) {
            if (str.startsWith(dictionary.get(ch), sIdx))
                return isPatternMatched(pattern, pIdx+1, str, sIdx+dictionary.get(ch).length(), dictionary);
            
            return false;
        }
        
        for (int k = sIdx+1; k <= str.length(); k++) {
            String tempStr = str.substring(sIdx, k);
            // if multi to one is illegal
            if (dictionary.containsValue(tempStr))
                continue;
            
            dictionary.put(ch, tempStr);
            if (isPatternMatched(pattern, pIdx+1, str, sIdx+tempStr.length(), dictionary))
                return true;
            dictionary.put(ch, null);
        }
        
        return false;
    }
}
