class Solution {
    private int indexOfLastChar(String S, int head, int tail, char c) {
        int last = tail;
        while (S.charAt(last) != c) 
            last--;
        return last;
    }
    
    private void generateOnePartition(List<Integer> list, String S, int head, int tail) {
        List<Integer> partition = new ArrayList<Integer>();
        int first = head;
        int last = indexOfLastChar(S, head, tail, S.charAt(head));
        if (last > first) {
            for (int i = first + 1; i < last; i++) {
                int newLast = indexOfLastChar(S, i, tail, S.charAt(i));
                if (newLast > last)
                    last = newLast;
            }
        }
        list.add(last - first + 1);
        if (last != tail) 
            generateOnePartition(list, S, last + 1, tail);
    }
    
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitionLabels = new ArrayList<Integer>();
        generateOnePartition(partitionLabels, S, 0, S.length() - 1);
        return partitionLabels;
    }
}


/*
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        
        List<Integer> partitionLabels = new ArrayList<Integer>();
        int head = 0;
        int tail = 0;
        while (head < S.length()) {
            tail = last[S.charAt(head) - 'a'];
            for (int i = head;i < tail;i++) {
                int newTail = last[S.charAt(i) - 'a'];
                tail = newTail > tail ? newTail : tail;
            }
            partitionLabels.add(tail - head + 1);
            head = tail + 1;
        }
        
        return partitionLabels;
    }
}
*/


/* 
faster than the first one 
recursion is unnecessary
*/