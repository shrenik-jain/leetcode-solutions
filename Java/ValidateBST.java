/*
Question : Given the root of a binary tree, determine if it is a valid binary search tree (BST).

           A valid BST is defined as follows:
           1. The left subtree of a node contains only nodes with keys less than the node's key.
           2. The right subtree of a node contains only nodes with keys greater than the node's key.
           3. Both the left and right subtrees must also be binary search trees.
           
Link : https://leetcode.com/problems/validate-binary-search-tree/
*/

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    boolean checkBST(TreeNode node, long min, long max){
        if(node == null)
            return true;
        
        if(node.val <= min || node.val >= max)
            return false;
        
        return (checkBST(node.left, min, node.val) &&
                checkBST(node.right, node.val, max));
    }
}
