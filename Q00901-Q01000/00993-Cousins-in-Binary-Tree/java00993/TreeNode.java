package java00993;

/**
 * @Author: alton
 * @Date: Created in 5/17/21 9:06 AM
 * @Description:
 */
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
