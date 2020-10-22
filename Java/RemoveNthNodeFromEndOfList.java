/*
Question : 

Link : 
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i = 1; i < n && fast.next != null; i++) {
            fast = fast.next;
        }
        
        boolean first = true;
        
        while(fast.next != null) {
            
            first = false;
            fast = fast.next;
            
            if (fast.next != null)
                slow = slow.next;
        }
        
        if(first) 
            return head = head.next;
   
        if(slow.next != null) 
            slow.next = slow.next.next;               
 
        else 
            head = null;
        
        return head;                 
    }
}
