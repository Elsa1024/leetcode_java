class Solution {
    public void concatList(List<List<Integer>> permutation, List<Integer> list, List<Integer> nums, int length) {
        if (list.size() + 1 == length) {
            for (Integer number : nums) {
                List<Integer> finalNums = new ArrayList(list);
                finalNums.add(number);
                permutation.add(finalNums);
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                Integer number = nums.get(i);
                List<Integer> nextList = new ArrayList(list);
                nextList.add(number);
                List<Integer> nextNums = new ArrayList(nums);
                nextNums.remove(i);
                // System.out.println("number: " + number + ", nextList: " + Arrays.toString(nextList.toArray()) + ", nextNums: " + Arrays.toString(nextNums.toArray()));
                concatList(permutation, nextList, nextNums, length);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {   
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> permutation = new ArrayList<>();
        if (nums != null && nums.length > 0) {
        List<Integer> numberList = new ArrayList<>();
            for (int num : nums) 
                numberList.add(num);
            concatList(permutation, list, numberList, numberList.size());
        }
        return permutation;
    }
}
