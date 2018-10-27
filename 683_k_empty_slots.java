class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] garden = new int[flowers.length+1];
        for (int i = 0; i < flowers.length; i++) {
            int position = flowers[i];
            int left = position-k-1, right = position+k+1;
            if (left > 0 && garden[left] == 1) {
                int j = left+1;
                while (j < position) {
                    if (garden[j] == 1)
                        break;
                    j++;
                }
                if (j == position)
                    return i+1;
            }
            if (right < garden.length && garden[right] == 1) {
                int j = position+1;
                while (j < right) {
                    if (garden[j] == 1)
                        break;
                    j++;
                }
                if (j == right)
                    return i+1;
            }
            garden[position] = 1;
        }
        return -1;
    }
}
