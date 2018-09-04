# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if len(intervals) < 2:
            return intervals
        intervals = sorted(intervals, key = lambda x : x.start)
        ans = [intervals[0]]
        for interval in intervals[1:]:
            if interval.start <= ans[-1].end:
                ans[-1].end = max(interval.end, ans[-1].end)
            else:
                ans.append(interval)
                
        return ans
