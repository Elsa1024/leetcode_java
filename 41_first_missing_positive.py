class Solution:
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in range(len(nums)):
            while 0 <= nums[i] < len(nums) and nums[nums[i]-1] != nums[i]:
                temp = nums[i]
                nums[i] = nums[nums[i]-1]
                nums[temp-1] = temp        
        for i in range(len(nums)):
            if nums[i] != i+1:
                return i+1
        return len(nums)+1
