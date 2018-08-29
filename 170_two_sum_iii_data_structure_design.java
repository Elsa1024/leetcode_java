class TwoSum {
    Map<Integer, Integer> numberMap;
    List<Integer> numberList;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        numberMap = new HashMap();
        numberList = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (numberMap.get(number) == null) {
            numberMap.put(number, 0);
            numberList.add(number);
        }
        numberMap.put(number, numberMap.get(number) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer number : numberList) {
            int target = value - number;
            if ((target == number && numberMap.get(number) > 1) || (target != number && numberMap.get(target) != null))
                return true;
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
