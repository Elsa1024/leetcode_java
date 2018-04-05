public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversedInt = 0;
        for (int i = 0;i < 32;i++) {
            reversedInt += n & 1;
            n >>>= 1;
            if (i < 31) 
                reversedInt <<= 1;
        }
       
        return reversedInt;
    }
}
