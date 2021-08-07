package java00429.m04;
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

import java00001.Node;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> levelOrder(Node root) {
        
        if (root == null) {
            return res;
        }

        bfs(root, 0);

        return res;
    }

    private void bfs(Node node, int level) {

        if (node == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        for (Node n: node.children) {
            bfs(n, level + 1);
        }

    }
}