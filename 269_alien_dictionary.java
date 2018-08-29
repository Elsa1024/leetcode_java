class Solution {
    private final int N = 26;

    public String alienOrder(String[] words) {
        boolean[][] adjMtx = new boolean[N][N];
        int[] visited = new int[26];
        constructGraph(words, adjMtx, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0 && !dfs(adjMtx, visited, sb, i))
                return "";
        }

        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adjMtx, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;
        for (int j = 0; j < N; j++) {
            if (adjMtx[i][j]) {
                if (visited[j] == 1) return false;
                if (visited[j] == 0 && !dfs(adjMtx, visited, sb, j))
                    return false;
            }
        }
        visited[i] = 2;
        sb.append((char) (i + 'a'));
        return true;
    }

    public void constructGraph(String[] words, boolean[][] adjMtx, int[] visited) {
        Arrays.fill(visited, -1);
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray())
                visited[c - 'a'] = 0;
            if (i > 0) {
                String w1 = words[i-1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adjMtx[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }    
}
