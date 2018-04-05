class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0;i < nums.length - 2;i++) {
            if (i > 0 && nums[i] == nums[i-1]) 
                continue;
            
            int j = i+1;
            int k = nums.length - 1;
            
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    sumList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return sumList;
    }
}
/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0;i < nums.length - 2;i++) {
            if (i > 0 && nums[i] == nums[i-1]) 
                continue;
            
            for (int j = i+1;j < nums.length - 1;j++) {
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;
                
                for (int k = j+1;k < nums.length;k++) {
                    if (k > j+1 && nums[k] == nums[k-1])
                        continue;
                    
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sum = new ArrayList<>();
                        sum.add(nums[i]);
                        sum.add(nums[j]);
                        sum.add(nums[k]);
                        sumList.add(sum);
                    }
                }
            }
        }
        
        return sumList;
    }
}
*/
/* timeout */


