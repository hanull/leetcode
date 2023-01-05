/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        if (size == 1) return null;
        if (size-n == 0) {
            head=head.next;
            return head;
        }
        ListNode prev = head;
        ListNode current = head.next;
        for (int i=1; i<size-n; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        
        return head;
    }
    
    public int getSize(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
}