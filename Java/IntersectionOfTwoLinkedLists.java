/*
Question : Write a program to find the node at which the intersection of two singly linked lists begins.

Link : https://leetcode.com/problems/intersection-of-two-linked-lists/
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) { return null;}
        
        ListNode t1 = headA;
        ListNode t2 = headB;
        
        while(t1 != t2) {
            
            if(t1 == null) {
                t1 = headB;
            }
            else {
                t1 = t1.next; 
            } 
            
            if(t2 == null) {
                t2 = headA;
            }
            else {
                t2 = t2.next; 
            } 
        }
        
       return t1; 
    }
}
