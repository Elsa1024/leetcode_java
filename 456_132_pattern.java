public class Solution {
    public boolean find132pattern(int[] nums) {
        int min_i = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length - 1; j++) {
            min_i = Math.min(nums[j], min_i);
            for (int k = j+1; k < nums.length; k++) {
                if (nums[k] > min_i && nums[k] < nums[j])
                    return true;
            }
        }
        return false;
    }
}

