class Solution {
    public boolean isEqual(List<String> words, int x, int y) {
        return (words.get(x).length() <= y && (words.size() <= y || words.get(y).length() <= x)) 
        || (words.get(x).length() > y && words.size() > y && words.get(y).length() > x && words.get(x).charAt(y) == words.get(y).charAt(x));
    }
    
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0)
            return true;
        
        int col = words.size();
        for (String word : words)
            col = Math.max(col, word.length());
        
        for (int i = 0; i < words.size(); i++) {
            for (int j = i+1; j < col; j++) {
                if (!isEqual(words, i, j))
                    return false;
            }
        }
        return true;
    }
}
