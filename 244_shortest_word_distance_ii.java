class WordDistance {
    Map<String, List<Integer>> wordToIndex;

    public WordDistance(String[] words) {
        wordToIndex = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (wordToIndex.get(word) == null)
                wordToIndex.put(word, new ArrayList<>());
            wordToIndex.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        // O(max(m, n)) rather than O(m*n)
        List<Integer> indexList1 = wordToIndex.get(word1);
        List<Integer> indexList2 = wordToIndex.get(word2);
        int minDis = Integer.MAX_VALUE;
        
        for (int i = 0, j = 0; i < indexList1.size() && j < indexList2.size(); ) {
            int index1 = indexList1.get(i), index2 = indexList2.get(j);
            if (index1 < index2) {
                minDis = Math.min(minDis, index2 - index1);
                i++;
            } else {
                minDis = Math.min(minDis, index1 - index2);
                j++;
            }
        }
        
        return minDis;
    }
}
