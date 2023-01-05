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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = head;
        ListNode prev = temp;
        while (current != null && current.next != null) {
            ListNode swap1 = current;
            ListNode swap2 = current.next;
            current.next = swap2.next;
            prev.next = swap2;
            swap2.next = swap1;
            prev = current;
            current = prev.next;
        }
        return temp.next;
    }
}