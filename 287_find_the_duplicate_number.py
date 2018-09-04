class Solution:
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lo, hi = 0, len(nums)-1
        mid = lo + (hi-lo)//2
        while hi - lo > 1:
            counter = 0
            for num in nums:
                if mid < num <= hi:
                    counter += 1
            if counter > hi-mid:
                lo = mid
            else:
                hi = mid
            mid = lo + (hi-lo)//2
        return hi
