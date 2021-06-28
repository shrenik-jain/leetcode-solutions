/*
Question : Merge two sorted linked lists and return it as a sorted list. 
           The list should be made by splicing together the nodes of the first two lists.

Link : https://leetcode.com/problems/merge-two-sorted-lists/
*/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null){return l1;}
        else if(l1 == null && l2 != null) { return l2;}
        else if(l1 != null && l2 == null) { return l1;}
        
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        ListNode one = l1;
        ListNode two = l2;
        
        while(one != null && two != null) {
            
            if(one.val <= two.val) {
                res.next = one;
                one = one.next;
                res = res.next;
            }
            else {
                res.next = two;
                two = two.next;
                res = res.next;
            }
        }
        
        while(one != null) {
            res.next = one;
            one = one.next;
            res = res.next;
        }
        
        while(two != null) {
            res.next = two;
            two = two.next;
            res = res.next;
        }
        
        return temp.next;
    }
}
