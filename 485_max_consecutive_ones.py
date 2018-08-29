class Solution:
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        counter = 0
        max_counter = 0
        for num in nums:
            if num == 1:
                counter += 1
            else:
                max_counter = max(max_counter, counter)
                counter = 0
        max_counter = max(max_counter, counter)
        return max_counter
