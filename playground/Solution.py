class Interval:
    def __init__(self, s=1, e=4):
        self.start = s
        end = e

def merge(intervals):
    starts, ends = [], []
    ans = []
    for interval in intervals:
        starts.append(interval.start)
        ends.append(interval.end)
    starts.sort()
    ends.sort()
    if len(starts) == 0:
        return ans
    start, end = starts.pop(0), ends[0]+1
    start_count, end_count = 1, 0
    while len(ends):
        while len(ends) and ends[0] == end:
            ends.pop(0)
        if len(ends) == 0:
            break
        end = ends.pop(0)
        end_count += 1
        while len(starts) and starts[0] <= end:
            starts.pop(0)
            start_count += 1
        if start_count == end_count:
            ans.append(Interval(start, end))
            if len(starts):
                start = starts.pop(0)
                start_count += 1
    return ans

interval = Interval()
intervals = [interval, interval]
ret = merge(intervals)
print("ret: ", ret)