class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i-1] > nums[i])
                    swap(nums, i, i-1);
            } else if (i != 0 && nums[i-1] < nums[i])
                swap(nums, i, i-1);
        }
    }
    
    public void swap(int[] nums, int index0, int index1) {
        int temp = nums[index0];
        nums[index0] = nums[index1];
        nums[index1] = temp;
    }
}
