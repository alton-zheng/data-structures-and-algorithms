package java00429.m02;

import java00001.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }


        List<Node> nodes = new ArrayList<>();

        nodes.add(root);



        while (nodes.size() > 0) {
            int size = nodes.size();
            List<Integer> cur = new ArrayList<>();
            List<Node> children = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = nodes.get(i);
                if (node.children != null) {
                    children.addAll(node.children);
                }
                cur.add(node.val);
            }

            if (cur.size() > 0) {
                res.add(cur);
            }

            nodes.clear();
            if (children.size() > 0) {
                nodes.addAll(children);
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