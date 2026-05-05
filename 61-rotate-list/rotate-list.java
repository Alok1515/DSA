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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        // step 1 : find the length and tail of linkedlist
        int length = 1; // it self a node thats why 1
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }
        if(k % length == 0) return head; // no imapct on linked list
        
        // step 2 : make it cicular
        tail.next = head;

        // step 3 : find new head and tail
        k = k % length; // get smaller value
        int stepsToNewNode = length - k;
        ListNode newTail = tail;

        while(stepsToNewNode-- > 0) {
            newTail = newTail.next;
        }

        // step 4 : Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
