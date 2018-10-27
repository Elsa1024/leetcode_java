class Solution:
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        ans = list(s)
        left, right = 0, len(s)-1
        vowels = set(['a','e','i','o','u','A','E','I','O','U'])
        while left < right:
            while left < right and ans[left] not in vowels:
                left += 1
            while left < right and ans[right] not in vowels:
                right -= 1
            ans[left], ans[right] = ans[right], ans[left]
            left += 1
            right -= 1
        return ''.join(ans)
        
