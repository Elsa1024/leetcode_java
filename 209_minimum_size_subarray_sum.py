class Solution:
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        if nums == False:
            return -1
        if s == 0:
            return 0
        
        minLen = len(nums)+1
        start = 0
        prevSum = 0
        for i in range(len(nums)):
            if (nums[i] >= s):
                return 1
            prevSum += nums[i]
            if (prevSum >= s):
                while prevSum - nums[start] >= s:
                    prevSum -= nums[start]
                    start += 1
                minLen = min(i-start+1, minLen)
                prevSum -= nums[start]
                start += 1
        
        return 0 if minLen > len(nums) else minLen
