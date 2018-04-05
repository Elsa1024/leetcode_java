import java.util.*;
import java.lang.*;

public class MainClass {
    public static void main(String[] args) {
    	MaxStack maxStack = new MaxStack();	
    	maxStack.push(5);	
    	maxStack.push(1);	
    	maxStack.push(5);	

    	System.out.println("maxStack: " + Arrays.toString(maxStack.maxStack.toArray()));
    	
    	System.out.println("top: " + maxStack.top());
    	System.out.println("popMax: " + maxStack.popMax());
    	System.out.println("maxStack: " + Arrays.toString(maxStack.maxStack.toArray()));
    	System.out.println("top: " + maxStack.top());
    	System.out.println("peekMax: " + maxStack.peekMax());
    	System.out.println("maxStack: " + Arrays.toString(maxStack.maxStack.toArray()));
    	System.out.println("pop: " + maxStack.pop());
    	System.out.println("top: " + maxStack.top());
    }
}
