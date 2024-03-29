package java00589.m02;

import java00589.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 6/13/21 10:51 AM
 * @Description:
 *
 * 589. N-ary Tree Preorder Traversal #108
 *
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The height of the n-ary tree is less than or equal to 1000.
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Time Complexity: O(M)
 * Space Complexity: O(M)
 *
 * Runtime: 2 ms, faster than 37.45% of Java online submissions for N-ary Tree Preorder Traversal.
 * Memory Usage: 43.2 MB, less than 5.45% of Java online submissions for N-ary Tree Preorder Traversal.
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

    public List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();

        while (root != null) {
            res.add(root.val);
            List<Node> node = root.children;
            for (int i = node.size() - 1; i >= 0; i--) {
                if (node.get(i) != null) {
                    stack.push(node.get(i));
                }
            }

            root = stack.poll();
        }

        return res;

    }
}
