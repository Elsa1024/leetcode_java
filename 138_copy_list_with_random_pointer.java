public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        
        RandomListNode newHead = null, newNode = null, node = head;
        Map<Integer, Integer> hashCodeToIndex = new HashMap();
        
        int i = 0;
        while (node != null) {
            hashCodeToIndex.put(node.hashCode(), i++);
            if (newHead == null) {
                newHead = new RandomListNode(node.label);
                newNode = newHead;
            } else {
                newNode.next = new RandomListNode(node.label);
                newNode = newNode.next;
            }
            node = node.next;
        }   
        newNode.next = null;
        
        node = head;
        newNode = newHead;
        RandomListNode randomNode;
        int index;
        while (node != null) {
            if (node.random == null) {
                newNode.random = null;
            } else {
                index = hashCodeToIndex.get(node.random.hashCode());
                randomNode = newHead;
                i = 0;
                while (i < index) {
                    randomNode = randomNode.next;
                    i++;
                }
                newNode.random = randomNode;
            }
            node = node.next;
            newNode = newNode.next;
        }
        
        return newHead;
    }
}

// passed but tooooo slow
// good to use map but far than enough...
/*
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        
        RandomListNode newHead = null, newNode = null, node = head;
        Map<RandomListNode, RandomListNode> oldToNew = new HashMap();
        while (node != null) {
            newNode = new RandomListNode(node.label);
            oldToNew.put(node, newNode);
            node = node.next;
        }
        
        node = head;
        while (node != null) {
            newNode = oldToNew.get(node);
            newNode.next = node.next == null ? null : oldToNew.get(node.next);
            newNode.random = node.random == null ? null : oldToNew.get(node.random);
            node = node.next;
        }
        
        return oldToNew.get(head);
    }
}
*/
