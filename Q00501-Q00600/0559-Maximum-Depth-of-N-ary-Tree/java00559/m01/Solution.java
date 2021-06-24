package java00559.m01;

import java00559.Node;

/**
 * @Author: alton
 * @Date: Created in 6/24/21 9:02 PM
 * @Description:
 * 559. Maximum Depth of N-ary Tree #143
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [0, 10^4].
 *
 * dfs
 *
 * Time Complexity : O(n)
 * Space Complexity : O(h)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of N-ary Tree.
 * Memory Usage: 39.1 MB, less than 58.77% of Java online submissions for Maximum Depth of N-ary Tree.
 *
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return getMaxDepth(root, 1);
    }

    private int getMaxDepth(Node node, int depth) {
        if (node.children == null) {
            return depth;
        }

        int res = depth;

        for (Node children: node.children) {
            res = Math.max(res, getMaxDepth(children, depth + 1));
        }

        return res;
    }
}
