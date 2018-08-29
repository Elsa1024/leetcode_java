/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) 
            return false;
        Set nodeSet = new HashSet();
        ListNode helper = head.next;
        while (helper != null) {
            if (!nodeSet.add(helper))
                return true;
            helper = helper.next;
        }
        return false;
    }
}

/*
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) 
            return false;
        
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) 
                return true;
        }
        return false;
    }
}
*/

/* reference: http://codingfreak.blogspot.com/2012/09/detecting-loop-in-singly-linked-list_22.html */
