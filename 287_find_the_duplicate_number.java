class Solution {
    public int findDuplicate(int[] nums) {
        Set numberSet = new HashSet();
        for (int number : nums) {
           if (!numberSet.add(number))
               return number;
        }
        return 0;
    }
}
