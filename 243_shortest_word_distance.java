class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int[] index1 = new int[words.length];
        int[] index2 = new int[words.length];
        int minDis = Integer.MAX_VALUE, i = 0, j = 0;
        
        for (int k = 0; k < words.length; k++) {
            if (word1.equals(words[k]))
                index1[i++] = k;
            else if (word2.equals(words[k]))
                index2[j++] = k;
        }
        
        i--;
        j--;
        
        for (int k = 0; k <= i; k++) {
            int index = index1[k];
            if (index < index2[0])
                minDis = Math.min(minDis, index2[0] - index);
            else if (index > index2[j])
                minDis = Math.min(minDis, index - index2[j]);
            else {
                int cIdx = -Arrays.binarySearch(index2, 0, j, index)-1;
                minDis = Math.min(minDis, Math.min(index - index2[cIdx - 1], index2[cIdx] - index));
            }
        }
    
        return minDis;
    }
}
