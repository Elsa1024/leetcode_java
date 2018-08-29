class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        i = 0
        j = 0
        counter = -1
        
        median = 0
        len1 = len(nums1)
        len2 = len(nums2)
        if (len1+len2) % 2 == 0:
            idx1 = (len1+len2)//2 -1
            idx2 = idx1+1
        else:
            idx2 = idx1 = (len1+len2)//2
            
        ele = 0
        while i < len1 or j < len2:
            if i == len1:
                counter += 1
                ele = nums2[j]
                j += 1
            elif j == len2:
                counter += 1
                ele = nums1[i]
                i += 1
            else:
                if nums2[j] > nums1[i]:
                    ele = nums1[i]
                    i += 1
                else:
                    ele = nums2[j]
                    j += 1
                counter += 1
            if counter == idx1:
                median += ele
            if counter == idx2:
                median += ele
                break     
        return median/2         
        
