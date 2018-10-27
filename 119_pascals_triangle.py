class Solution:
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        ans = [1]
        for i in range(rowIndex):
            ans = [x + y for x, y in zip([0] + ans, ans + [0])]
        return ans
