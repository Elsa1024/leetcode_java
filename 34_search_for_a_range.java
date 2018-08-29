class Solution {
    public int binarySearch(int[] nums, int target, int head, int tail) {
        if (head == tail) 
            return nums[head] == target ? head : -1;
        
        int mid = head + (tail - head) / 2;
        if (nums[mid] == target)
            return mid;
        
        if (target > nums[mid])
            return binarySearch(nums, target, mid+1, tail);
        
        return binarySearch(nums, target, head, mid);
    }
    
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        
        int index = binarySearch(nums, target, 0, nums.length-1);
        if (index == -1) {
            return new int[]{-1, -1};
        } else {
            int left = index, right = index;
            while (left > 0 && nums[left-1] == target)
                left--;
            while (right < nums.length - 1 && nums[right+1] == target)
                right++;
            return new int[]{left, right};
        }
    }
}
