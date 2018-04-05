class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        int counter = 0;
        while (counter < n) {
            fast = fast.next;
            counter++;
        }
        if (fast == null) {
            head = head.next;
        } else {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}
