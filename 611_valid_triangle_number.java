class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        outerloop:
        for (int i = 0;i < nums.length - 2;i++) {
            iloop:
            for (int j = i+1;j < nums.length - 1;j++) {
                for (int k = j+1;k < nums.length;k++) {
                    if (nums[k] + nums[k-1] > nums[i]) {
                        if (nums[i] + nums[k] > nums[j]) {
                            if (nums[i] + nums[j] > nums[k])
                                 counter++;
                        } else {
                            break;
                        }
                    } else {
                        if (k == nums.length - 1)
                            break outerloop;
                    
                        break iloop;   
                    }
                }
            }
        }
        return counter;
    }
}
