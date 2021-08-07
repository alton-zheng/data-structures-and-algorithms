package java00429.m01;

import java00001.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 2021/8/7 9:10 上午
 * @Description:
 * 429. N-ary Tree Level Order Traversal
 *
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]


Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
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
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }


        Deque<Node> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            int curSize = stack.size();

            List<Integer> cur = new ArrayList<>();
            List<Node> children = new ArrayList<>();
            for (int i = 1; i <= curSize; i++) {
                Node node = stack.pop();
                cur.add(node.val);
                if (node.children != null) {
                    children.addAll(node.children);
                }
            }

            if (cur.size() > 0) {
                res.add(cur);
            }

            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Node> children = new ArrayList<>();

        children.add(new Node(5));
        children.add(new Node(4));
        System.out.println(new Solution().levelOrder(new Node(5, children)));
    }

}
