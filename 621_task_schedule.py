class Solution:
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        task_counters = collections.Counter(tasks).values()
        m = max(task_counters)
        m_m = list(task_counters).count(m)
        
        return max((m-1)*(n+1) + m_m, len(tasks))
