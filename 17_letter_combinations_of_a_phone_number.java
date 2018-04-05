class Solution {
    public void letterConcatenation(String[] letterMap, String digits, int index, String preStr, List<String> strList) {
        int digit = digits.charAt(index) - '0';
        String letters = letterMap[digit - 2];
        boolean isEnd = index == digits.length() - 1;
        if (letters != null) {
            for (Character letter : letters.toCharArray()) {
                String str = preStr + letter;
                if (isEnd)
                    strList.add(str);
                else
                    letterConcatenation(letterMap, digits, index+1, str, strList);
            }
        } else {
            if (isEnd)
                strList.add(preStr);
            else
                letterConcatenation(letterMap, digits, index+1, preStr, strList);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        String[] letterMap = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> strList = new ArrayList<>();
        if (digits != null && digits.length() > 0)
            letterConcatenation(letterMap, digits, 0, "", strList);
        return strList;
    }
}
