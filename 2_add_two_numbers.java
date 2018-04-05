class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        
        int set = 0;
        ListNode head = null, node = null;
        
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = (val1 + val2 + set) % 10;
            set = (val1 + val2 + set) / 10;
            if (node == null) {
                node = new ListNode(sum);
                head = node;
            } else {
                node.next = new ListNode(sum);
                System.out.println("head: " + head.val + ", node: " + node.val);
                node = node.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (set > 0)
            node.next = new ListNode(set);
        
        return head;
    }
}

// passed but too slow

/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        
        int set = 0;
        ListNode preNode = null, currNode = l1;
        
        while (currNode != null || l2 != null || set > 0) {
            int val1 = currNode != null ? currNode.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = (val1 + val2 + set) % 10;
            set = (val1 + val2 + set) / 10;
            
            if (currNode == null) {
                currNode = new ListNode(sum);
                preNode.next = currNode;
            } else {
                currNode.val = sum;
            }
            preNode = currNode;
            currNode = currNode.next;
            
            if (l2 != null) l2 = l2.next;
        }
        
        return l1;
    }
}
*/
// faster 
