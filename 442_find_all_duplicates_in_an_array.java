class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> frequentElements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i])-1;
            if (nums[val] > 0) 
                nums[val] = -nums[val];
            else
                frequentElements.add(val+1);
        }
        
        return frequentElements;
    }
}
