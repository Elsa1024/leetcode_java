class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap();
        for (int num : nums) {
            if (numMap.get(num) == null)
                numMap.put(num, 0);
            numMap.put(num, numMap.get(num) + 1);
        }
        
        List<Integer>[] frequency = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> num : numMap.entrySet()) {
            int fre = num.getValue();
            if (frequency[fre] == null)
                frequency[fre] = new ArrayList<>();
            frequency[fre].add(num.getKey());
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int counter = 0;
        for (int i = frequency.length - 1; i >= 0; i--) {
            if (frequency[i] != null) {
                result.addAll(frequency[i]);
                counter += frequency[i].size();
            }
            if (counter >= k)
                break;
        }
        
        return result.subList(0, k);
    }
}
