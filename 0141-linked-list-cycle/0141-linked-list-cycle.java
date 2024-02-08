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
        Set<ListNode> container = new HashSet<>();
        while (head != null) {
            if (container.contains(head)) {
                return true;
            }
            container.add(head);
            head = head.next;
        }
        return false;
    }
}