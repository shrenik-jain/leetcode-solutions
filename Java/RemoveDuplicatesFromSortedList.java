/*
Question : Given a sorted linked list, delete all duplicates such that each element appear only once.

Link : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*/

import java.io.*; 
import java.util.LinkedList; 

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = null;
        
        while(fast != null && fast.next != null) {
            
            slow = fast;
            fast = fast.next;
             
            if(slow.val == fast.val) {
                slow.next = fast.next;
                fast = slow;
            }
        }
        
        return head;    
    }
}
