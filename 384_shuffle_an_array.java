class Solution {
    private int[] originalNums;
    private Random random;
    private int length;
    
    public Solution(int[] nums) {
        length = nums.length;
        originalNums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalNums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffledNums = originalNums.clone();
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(i + 1);
            swap(shuffledNums, i, j);
        }
        
        return shuffledNums;
    }
    
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */


// Fisher–Yates shuffle modern version
