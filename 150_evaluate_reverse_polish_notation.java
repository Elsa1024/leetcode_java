class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int op_0, op_1;
        for (String token : tokens) {
            if (token.equals("+")) {
                op_1 = stack.pop();
                op_0 = stack.pop();
                stack.push(op_0 + op_1);
            } else if (token.equals("-")) {
                op_1 = stack.pop();
                op_0 = stack.pop();
                stack.push(op_0 - op_1);
            } else if (token.equals("/")) {
                op_1 = stack.pop();
                op_0 = stack.pop();
                stack.push(op_0 / op_1);
            } else if (token.equals("*")) {
                op_1 = stack.pop();
                op_0 = stack.pop();
                stack.push(op_0 * op_1); 
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
