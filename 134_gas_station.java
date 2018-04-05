class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank, target, counter, length = gas.length;
        
        for (int head = 0; head < length; head++) {
            counter = 0;
            tank = 0;
            while (counter < length) {
                target = (head + counter) % length;
                tank = tank + gas[target];
                tank = tank - cost[target];
                if (tank < 0)
                    break;
                counter++;
            }
    
            if (counter == length && tank >= 0)
                return head;
        }
        
        return -1;
    }
}
