class Solution {
    public String generateRange(long lower, long upper) {
        if (upper == lower)
            return upper + "";

        return lower + "->" + upper;
    }
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> rangeList = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            rangeList.add(generateRange(lower, upper));
            return rangeList;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > lower)
                    rangeList.add(generateRange(lower, nums[i]-1));
            } else if ((long)nums[i] - (long)nums[i-1] > 1) {
                rangeList.add(generateRange((long)nums[i-1]+1, (long)nums[i]-1));
            }
        }
       
        if (upper > (long)nums[nums.length - 1]) 
            rangeList.add(generateRange((long)nums[nums.length - 1]+1, upper));
       
        return rangeList;
    }
}
