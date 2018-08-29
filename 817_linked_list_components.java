/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        ListNode preNode = null, currNode = head;
        int counter = 0;
        Set<Integer> gSet = new HashSet<Integer>();
        for (int g : G) gSet.add(g);
        while (currNode != null) {
            if (gSet.contains(currNode.val)) {
                counter++;
                while (currNode != null && gSet.contains(currNode.val) && gSet.contains(currNode.val)) {
                    preNode = currNode;
                    currNode = currNode.next;
                }
            }
            if (currNode != null) {
                preNode = currNode;
                currNode = currNode.next;
            }
        }
        return counter;
    }
}
