/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public void traverse(List<NestedInteger> nestedList, List<Integer> list, int distance) {
        int primarySum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger())
                primarySum += ni.getInteger();
            else 
                traverse(ni.getList(), list, distance+1);
        }
        while (distance >= list.size())
            list.add(list.size(), 0);
        
        list.set(distance, list.get(distance) + primarySum);
    }
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        traverse(nestedList, list, 0);
        int depth = list.size(), sum = 0;
        for (int i = 0; i < depth; i++) 
            sum += (depth - i) * list.get(i);
        
        return sum;
    }
}
