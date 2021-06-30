package java00297.m01;

import java00297.TreeNode;

/**
 * @Author: alton
 * @Date: Created in 6/30/21 10:56 AM
 * @Description:
 * 297. Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * Runtime: 5 ms, faster than 98.48% of Java online submissions for Serialize and Deserialize Binary Tree.
 * Memory Usage: 40.7 MB, less than 81.10% of Java online submissions for Serialize and Deserialize Binary Tree.
 */
public class Codec {

    private StringBuilder help;
    private int curIdx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        help = new StringBuilder();
        preorder(root);
        return help.toString();

    }

    private void preorder(TreeNode node) {
        if (node == null) {
            help.append("null,");
        } else {
            help.append(node.val).append(",");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        curIdx = 0;
        return preOrderDeserialize(data.split(","));

    }

    private TreeNode preOrderDeserialize(String[] arr) {

        if ("null".equals(arr[curIdx]) || curIdx == arr.length) {
            curIdx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(arr[curIdx]));
        curIdx++;
        node.left = preOrderDeserialize(arr);
        node.right = preOrderDeserialize(arr);

        return node;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
