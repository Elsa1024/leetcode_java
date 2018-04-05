class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode oldTail = null, node = head;
        int size = 0;
        while (node != null) {
            if (node.next == null) {
                oldTail = node;
            }
            node = node.next;
            size++;
        }
        int idx = size - 1 - k % size;
        int counter = 0;
        ListNode newTail = head;
        while (counter < idx) {
            newTail = newTail.next;
            counter++;
        }
        ListNode newHead = newTail.next == null ? head : newTail.next;
                
        if (newTail.next != null) {
            oldTail.next = head;
        }
        newTail.next = null;
        return newHead;
    }
}
