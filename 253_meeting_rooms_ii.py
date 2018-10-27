# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        starts, ends = [], []
        for it in intervals:
            starts.append(it.start)
            ends.append(it.end)
        
        starts.sort(); ends.sort()
        
        end_idx, counter = 0, 0
        for s in starts:
            if s >= ends[end_idx]:
                end_idx += 1
                continue
            else:
                counter += 1
        
        return counter
