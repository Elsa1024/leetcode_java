class Solution {  
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1 == null || p1.length != 2 || p2 == null || p2.length != 2 || p3 == null || p3.length != 2 || p4 == null || p4.length != 2)
            return false;
      
        int[] v1 = new int[]{p2[0] - p1[0], p2[1] - p1[1]};
        int[] v2 = new int[]{p3[0] - p1[0], p3[1] - p1[1]};
        int[] v3 = new int[]{p4[0] - p1[0], p4[1] - p1[1]};
        
        int[] edge0 = new int[2];
        int[] edge1 = new int[2];
        int[] diagonal = new int[2];
        if (v1[0]*v2[0] + v1[1]*v2[1] == 0) {
            edge0 = v1;
            edge1 = v2;
            diagonal = v3;
        } else if (v1[0]*v3[0] + v1[1]*v3[1] == 0) {
            edge0 = v1;
            edge1 = v3;
            diagonal = v2;
        } else if (v2[0]*v3[0] + v2[1]*v3[1] == 0) {
            edge0 = v2;
            edge1 = v3;
            diagonal = v1;
        } else
            return false;
        
        int edgeLen0 = edge0[0]*edge0[0] + edge0[1]*edge0[1];
        int edgeLen1 = edge1[0]*edge1[0] + edge1[1]*edge1[1];
        int diaLen = diagonal[0]*diagonal[0] + diagonal[1]*diagonal[1];
        
        if (edgeLen0 > 0 && edgeLen0 == edgeLen1 && edgeLen0*2 == diaLen 
            && Math.abs(edge0[0]*diagonal[1] - edge0[1]*diagonal[0]) == edgeLen0 
            && Math.abs(edge1[0]*diagonal[1] - edge1[1]*diagonal[0]) == edgeLen0
            && (edge0[0]*diagonal[1] - edge0[1]*diagonal[0]) + (edge1[0]*diagonal[1] - edge1[1]*diagonal[0]) == 0) {
            return true;
        } else 
            return false;
    }
}
