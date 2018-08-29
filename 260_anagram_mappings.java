class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0 || A.length != B.length)
            return new int[0];
        
        List<Integer> listB = new ArrayList<>();
        for (int b : B)
            listB.add(b);
        
        int[] mapping = new int[A.length];
        for (int i = 0; i < A.length; i++)
            mapping[i] = listB.indexOf(A[i]);
        
        return mapping;
    }
}
