import java.util.*;
import java.lang.*;
import java.text.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int start = findGreaterEqual(nums, 0, nums.length, target);
        if (nums[start] != target)
            return new int[]{-1, -1};
        int end = findGreaterEqual(nums, 0, nums.length, target+1)-1;
        return new int[]{start, end};
    }
    
    private int findGreaterEqual(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (int)(hi-lo)/2;

            if (nums[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}