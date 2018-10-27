class Solution:
    def removeInvalidParenthesesHelper(self, queue):
        ans = []
        while queue:
            ss, removed_idx, idx = queue.pop(0)
            counter = 0
           
            for i in range(idx, len(ss)):
                if ss[i] == '(': 
                    counter += 1
                elif ss[i] == ')': 
                    counter -= 1
                    if counter < 0:
                        # end brackets are more than start brackets
                        j = removed_idx
                        while j <= i:
                            if ss[j] == ')':
                                sss = ss; sss = sss[0:j] + sss[j+1:]
                                queue.append((sss, j, i))
                                while j <= i and ss[j] == ')':
                                    j += 1
                            else:
                                j += 1
                        break
            if counter >= 0:
                ans.append(ss)
    
        return ans

        
    def reverseStr(self, s):
        ans = []
        for ss in s[::-1]:
            if ss not in ['(', ')']:
                ans.append(ss)
            else:
                ans.append('(' if ss == ')' else ')')
        return ''.join(ans)
    
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        ans, queue = [], [(s, 0, 0)]
        ans = self.removeInvalidParenthesesHelper(queue)
        for a in ans:
            queue.append((self.reverseStr(a), 0, 0))
        ans = self.removeInvalidParenthesesHelper(queue)
        return [self.reverseStr(a) for a in ans] 
