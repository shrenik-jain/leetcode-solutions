/*
Question : Implement a first in first out (FIFO) queue using only two stacks. 
           The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
           Implement the MyQueue class:
           1.void push(int x) Pushes element x to the back of the queue.
           2.int pop() Removes the element from the front of the queue and returns it.
           3.int peek() Returns the element at the front of the queue.
           4.boolean empty() Returns true if the queue is empty, false otherwise.

Link : https://leetcode.com/problems/implement-queue-using-stacks/
*/

class MyQueue {
    
    Stack <Integer> mainS;
    Stack <Integer> helperS;

    public MyQueue() {       
        mainS = new Stack<>();
        helperS = new Stack<>();    
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(mainS.size() > 0) {
            helperS.push(mainS.pop());
        }
        
        mainS.push(x);
        
        while(helperS.size() > 0) {
            mainS.push(helperS.pop());
        }      
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return mainS.pop();  
    }
    
    /** Get the front element. */
    public int peek() {
        return mainS.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(mainS.size() == 0) {
            return true;
        }
        
        else {
            return false;
        }   
    }
}
