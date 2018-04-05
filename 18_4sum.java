class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> solutionSet = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return solutionSet;
        
        Arrays.sort(nums);
        if (target > nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4])
            return solutionSet;
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int min = nums[i+1] + nums[i+2] + nums[i+3]; 
            if (target < min + nums[i])
                break;
            
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                int subTarget = target - nums[i];                
                for (int k = j + 1, m = nums.length - 1; k < m; ) {
                    int sum = nums[j] + nums[k] + nums[m];
                    if (sum == subTarget) {
                        solutionSet.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        k++;
                        m--;
                    } else if (sum < subTarget) {
                        k++;
                    } else {
                        m--;
                    }
                    while (k > j + 1 && k < m && nums[k] == nums[k-1])
                            k++;
                    while (m < nums.length - 1 && m > k && nums[m] == nums[m+1])
                            m--;
                }
            }
        }    
        return solutionSet;
    }
}
