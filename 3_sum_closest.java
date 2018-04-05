class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int lastSum = Integer.MAX_VALUE - 100, sum = 0, closestSum = Integer.MAX_VALUE - 100;
        Arrays.sort(nums);
        iLoop:
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            jkLoop:
            for (int j = i+1, k = nums.length - 1; j < k; ) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    closestSum = sum;
                    break iLoop;
                }
                
                if (Math.abs(sum - target) < Math.abs(closestSum - target))
                    closestSum = sum;
                
                lastSum = sum;

                if (sum < target)
                    j++;
                
                else 
                    k--;
                
                while (j > i+1 && j < k && nums[j] == nums[j-1])
                    j++;
                while (j < k && k < nums.length - 1 && nums[k] == nums[k+1])
                    k--;
            }
        }
        return closestSum;
    }
}
