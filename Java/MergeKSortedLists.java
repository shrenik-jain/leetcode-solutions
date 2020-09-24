/*
Question : You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
           Merge all the linked-lists into one sorted linked-list and return it.

Link : https://leetcode.com/problems/merge-k-sorted-lists/
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue <Integer> minHeap = new PriorityQueue<>();
        
        for(ListNode head : lists) {
            while(head != null) {             
                minHeap.add(head.val);          
                head = head.next;
            }
        }     
        ListNode dummy = new ListNode(0); 
        ListNode head = dummy;                                                      
        while(!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }       
        return dummy.next;          
    }
}
