import java.util.*;
import java.lang.*;
// avoid redundant comparation with 0
class MaxStack {
    List<Integer> maxStack;
    
    private int maxIndex() {
        Integer maxValue = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < maxStack.size(); i++) {
            if (maxStack.get(i) >= maxValue) {
                maxValue = maxStack.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /** initialize your data structure here. */
    public MaxStack() {
        maxStack = new ArrayList<>();
    }
    
    public void push(int x) {
        maxStack.add(x);
    }
    
    public int pop() {
        Integer top = maxStack.get(maxStack.size() - 1);
        maxStack.remove(maxStack.size() - 1);
        return top.intValue();
    }
    
    public int top() {
        Integer top = maxStack.get(maxStack.size() - 1);
        return top.intValue();
    }
    
    public int peekMax() {
        int maxIndex = maxIndex();
        return maxStack.get(maxIndex);
    }
    
    public int popMax() {
        int maxIndex = maxIndex();
        int maxValue = maxStack.get(maxIndex);
        maxStack.remove(maxIndex);
        return maxValue;
    }
}
