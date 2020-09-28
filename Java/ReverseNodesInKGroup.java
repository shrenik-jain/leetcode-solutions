/*
Question : Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
           k is a positive integer and is less than or equal to the length of the linked list. 
           If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Link : https://leetcode.com/problems/reverse-nodes-in-k-group/
*/

 class Solution {
    
    public int len(ListNode head) {
        int c = 0;
        while(head != null) {
            c++;
            head = head.next;
        }
        
        return c;
    }
     
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k > len(head)) {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int temp = 0;
        
        while(curr != null && temp < k) {
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            temp++;
        }
        
        if(next != null) {
            head.next = reverseKGroup(next , k);
        }
        
        return prev;
    }
}
