/*
Question : Reverse a singly linked list.

Link : https://leetcode.com/problems/reverse-linked-list/
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode current = head;
        ListNode temp = null;
        
        while(current != null) {
            
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
