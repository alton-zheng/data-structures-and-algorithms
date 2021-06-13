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

Runtime: 48 ms, faster than 5.07% of C++ online submissions for N-ary Tree Preorder Traversal.
Memory Usage: 106.9 MB, less than 5.45% of C++ online submissions for N-ary Tree Preorder Traversal.
*/

class Solution {
private:
    vector<int> res;
public:
    vector<int> preorder(Node* root) {
        if (root == nullptr) {
            return res;
        }

        res.push_back(root -> val);
        for (auto* node: root -> children) {
            preorder(node);
        }

        return res;
    }
};