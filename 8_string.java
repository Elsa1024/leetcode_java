class Solution {
    public int myAtoi(String str) {
        int head = 0, tail;
        str = str.trim();
        char[] chars = str.toCharArray();
        // System.out.println("chars: " + Arrays.toString(chars));
        boolean isNegative = false;
        if (chars.length == 0)
            return 0;

        if (chars[0] == '-') {
            isNegative = true;
            head++;
        } else if (chars[0] == '+')
            head++;

        if (head == chars.length || !Character.isDigit(chars[head]))
            return 0;

        // System.out.println("1 head: " + head);
        
        tail = head+1;
        while (tail < chars.length) {
            if (Character.isDigit(chars[tail]))
                tail++;
            else 
                break;
        }

        // System.out.println("2 tail: " + tail);
        
        if (!Character.isDigit(chars[tail-1]))
            return 0;
                
        while (head < tail) 
            if (Character.getNumericValue(chars[head]) == 0)
                head++;
            else
                break;

        // System.out.println("head: " + head + ", tail: " + tail);

        if (head == tail)
            return 0;

        String numberStr = str.substring(head, tail);

        // System.out.println("numberStr: " + numberStr);
        int number;
        try {
            return isNegative ? 0 - Integer.parseInt(numberStr) : Integer.parseInt(numberStr);
         } catch (NumberFormatException e) {
            if (isNegative)
                return Integer.MIN_VALUE; 
            return Integer.MAX_VALUE;
        }
    }
}
