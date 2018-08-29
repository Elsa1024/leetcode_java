class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missedNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i+1) {
                i++;
                continue;
            } else {
                if (nums[nums[i]-1] != nums[i])
                    swap(nums, i, nums[i]-1);
                else 
                    i++;
            }
        }
        
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i+1)
                missedNumbers.add(i+1);
        
        return missedNumbers;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// passed but too slow
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missedNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i])-1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missedNumbers.add(i+1);
        }
        
        return missedNumbers;
    }
}
