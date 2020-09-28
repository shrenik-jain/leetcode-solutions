/*
Question : You are given two non-empty linked lists representing two non-negative integers. 
           The digits are stored in reverse order and each of their nodes contain a single digit.
           Add the two numbers and return it as a linked list.
           You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Link : https://leetcode.com/problems/add-two-numbers/
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;
            
            ListNode node = new ListNode(digit);
            l3.next = node;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            l3 = l3.next;
        }
        
        if(carry > 0) {
            ListNode node = new ListNode(carry);
            l3.next = node;
            l3 = l3.next;
        }
        return dummy.next;
    }
}
