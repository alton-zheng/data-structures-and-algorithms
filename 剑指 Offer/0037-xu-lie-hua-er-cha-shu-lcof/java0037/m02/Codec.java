package java0037.m02;

/**
 * @Author: alton
 * @Date: Created in 6/30/21 8:31 AM
 * @Description:
 * 0037-xu-lie-hua-er-cha-shu-lcof #160
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 *  
 *
 * 示例：
 *
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * Time Complexity : O()
 * Space Complexity : O()
 */

import java0037.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Runtime: 5 ms, faster than 98.48% of Java online submissions for Serialize and Deserialize Binary Tree.
// Memory Usage: 40.7 MB, less than 81.10% of Java online submissions for Serialize and Deserialize Binary Tree.
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
