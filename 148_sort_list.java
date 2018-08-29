class Solution {
    private int compare(ListNode x, ListNode y) {
        if (x.val >= y.val)
            return 1;
        return -1;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head, node, leftNode = left, rightNode = right;
        
        if (compare(left, right) == 1) {
            head = node = rightNode;
            rightNode = rightNode.next;
        } else {
            head = node = leftNode;
            leftNode = leftNode.next;
        }
        
        while (leftNode != null || rightNode != null) {
            if (leftNode == null) {
                node.next = rightNode;
                return head;
            }
            if (rightNode == null) {
                node.next = leftNode;
                return head;
            }
            if (compare(leftNode, rightNode) == 1) {
                node.next = rightNode;
                node = node.next;
                rightNode = rightNode.next;
            } else {
                node.next = leftNode;
                node = node.next;
                leftNode = leftNode.next;
            }
        }
        return head;
    }
    
    private ListNode sort(ListNode head, ListNode tail, int length) {
        if (length == 1)
            return head;
        if (length == 2) {
            if (compare(head, tail) == 1) {
                head.next = null;
                tail.next = head;
                return tail;
            }
            return head;
        }
        ListNode mid = head;
        int idx = 0;
        while (idx < length / 2 - 1) {
            mid = mid.next;
            idx++;
        }
        
        ListNode right = sort(mid.next, tail, length - length / 2);
        mid.next = null;
        ListNode left = sort(head, mid, length / 2);
        return merge(left, right);
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        int length = 1;
        ListNode node = head, tail;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        tail = node;
        return sort(head, tail, length);
    }
}
