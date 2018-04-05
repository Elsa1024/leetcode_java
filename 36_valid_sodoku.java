class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int length = 9;
        List<Set<Character>> rowSetList = new ArrayList<>();
        for (int i = 0; i < length; i++)
            rowSetList.add(new HashSet());
        List<Set<Character>> colSetList = new ArrayList<>();
        for (int i = 0; i < length; i++)
            colSetList.add(new HashSet());
        List<Set<Character>> sudokuSetList = new ArrayList<>();
        for (int i = 0; i < (length / 3)*(length / 3); i++)
            sudokuSetList.add(new HashSet());
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char ch  = board[i][j];
                if (ch < '1' || ch > '9')
                    continue;
                if (!rowSetList.get(i).add(ch) || !colSetList.get(j).add(ch) || !sudokuSetList.get(i/3*(length/3) + j/3).add(ch))
                    return false;
            }
        }
        return true;
    }
}
