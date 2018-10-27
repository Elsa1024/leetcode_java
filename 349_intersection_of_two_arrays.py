class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        i, j = 0, 0
        ans = []
        while i < len(nums1) or j < len(nums2):
            if i == len(nums1) or j == len(nums2):
                break
            if nums1[i] > nums2[j]:
                j += 1
            elif nums1[i] < nums2[j]:
                i += 1
            else:
                if (i == 0 or nums1[i-1] != nums1[i]) and (j == 0 or nums2[j-1] != nums2[j]):
                    ans.append(nums1[i])
                i += 1
                j += 1
        return ans
