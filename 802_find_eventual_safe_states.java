class Solution {
    private boolean isEventualSafeNode(int node, Set<Integer> safeNodes, Set<Integer> unsafeNodes, int[][] graph, Set<Integer> path) {
        if (!path.add(node))
            return false;

        if (safeNodes.contains(node)) 
            return true;
        
        if (unsafeNodes.contains(node))
            return false;
        
        if (graph[node].length > 0) {
            for (int i : graph[node]) {
                Set<Integer> subPath = new HashSet(path);
                if (!isEventualSafeNode(i, safeNodes, unsafeNodes, graph, subPath)) {
                    unsafeNodes.add(node);
                    return false;
                }
            }
        }
        safeNodes.add(node);
        return true;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> safeNodes = new HashSet();
        Set<Integer> unsafeNodes = new HashSet();
        
        for (int i = 0; i < graph.length; i++) {
            Set<Integer> path = new HashSet();
            isEventualSafeNode(i, safeNodes, unsafeNodes, graph, path);
        }
        List<Integer> safeNodeList = new ArrayList<Integer>(safeNodes);
        Collections.sort(safeNodeList);
        return safeNodeList;
    }
}
