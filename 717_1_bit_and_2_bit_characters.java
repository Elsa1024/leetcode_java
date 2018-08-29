class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean isOneBit = false;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 0) {
                isOneBit = true;
            } else if (bits[i] == 1 && (bits[i+1] == 1 || bits[i+1] == 0)) {
                isOneBit = false;
                i++;
            }
        }
        
        return isOneBit;
    }
}

// class Solution {
//     public boolean isOneBitCharacter(int[] bits) {
//         int i = 0;
//         while (i < bits.length - 1)
//             i += bits[i] + 1;
//         return i == bits.length - 1;
//     }
// }
