/*
Question : Given a non-empty, singly linked list with head node head, return a middle node of linked list.
           If there are two middle nodes, return the second middle node.

Link : https://leetcode.com/problems/middle-of-the-linked-list/
*/

/*
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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        if(head != null)
        {
            while(fast != null && fast.next != null)
            {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return slow;  
    }
}
