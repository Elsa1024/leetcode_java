/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int length = intervals.length;
        int[] starts = new int[length];
        int[] ends = new int[length];
        int counter = 0, start = 0, end = 0;
        
        for (int i = 0; i < length; i++) {
            Interval interval = intervals[i];
            starts[i] = interval.start;
            ends[i] = interval.end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
                
        for (; start < length; start++) {
            if (starts[start] < ends[end])
                counter++;
            else 
                end++;
        }
        
        return counter;
    }
}
