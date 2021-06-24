// Runtime: 16 ms, faster than 65.85% of C++ online submissions for Maximum Depth of N-ary Tree.
// Memory Usage: 10.8 MB, less than 66.68% of C++ online submissions for Maximum Depth of N-ary Tree.
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    int maxDepth(Node* root) {

        if (root == nullptr) {
            return 0;
        }

        return getMaxDepth(root, 1);
    }

private: int getMaxDepth(Node* node, int depth) {
        if (node -> children.size() == 0) {
            return depth;
        }

        int res = depth;

        for (auto& children: node -> children) {
            res = max(res, getMaxDepth(children, depth + 1));
        }

        return res;
    }
};